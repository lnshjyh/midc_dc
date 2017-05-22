package org.cw.midc.controller;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.cw.midc.Response;
import org.cw.midc.page.Page;
import org.apache.commons.codec.binary.Base64;
import org.cw.midc.ParamFilter;
import org.cw.midc.aop.annotaion.WebLogger;
import org.cw.midc.entity.User;
import org.cw.midc.service.UserService;
//import org.cw.midc.util.DrawImage;
import org.cw.midc.util.FileService;
import org.cw.midc.util.UserContextUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static final int BYTES_DOWNLOAD = 4096;
	private static final int MINIWIDTH = 200;
	private static final int MINIHEIGHT = 100;

    @Resource
    private UserService userService;
    @Resource
    private FileService fileService;

    @GetMapping("listPage")
    public String list(ModelMap modelMap) {
    	User user = (User) UserContextUtil.getAttribute("currentUser");
    	modelMap.put("userid",user.getUserId());
    	
        return "userList";
    }


    @ResponseBody
    @PostMapping("list")
    @WebLogger("查询用户列表")
    public Response list(@RequestBody  ParamFilter queryFilter) {
        List userList = userService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(userList,page);
    }

    @ResponseBody
    @PostMapping("add")
    @WebLogger("添加用户")
    public Response add(@RequestBody User user) {
        checkNotNull(user, "用户不能为空");
        userService.add(user);
        return new Response("添加成功");
    }


    @ResponseBody
    @PostMapping("edit")
    @WebLogger("编辑用户")
    public Response edit(@RequestBody User user) {
        userService.update(user);
        return new Response("修改成功");
    }

    @ResponseBody
    @PostMapping("delete")
    @WebLogger("删除用户")
    public Response delete(@RequestBody List<String> userIds) {
        checkArgument((userIds != null && userIds.size() > 0), "用户编号不能为空");
        userService.delete(userIds);
        return new Response("删除成功");
    }

    @ResponseBody
    @PostMapping("resetPwd")
    @WebLogger("重置密码")
    public Response resetPwd(@RequestBody List<String> userIds) {
        checkArgument((userIds != null && userIds.size() > 0), "用户编号不能为空");
        userService.updateDefaultPwd(userIds);
        return new Response("重置成功");
    }


    @ResponseBody
    @PostMapping("changePwd")
    @WebLogger("更改密码")
    public Response changePwd(String originPwd, String confirmPwd, String newPwd) {
        userService.updatePwd(originPwd, newPwd, confirmPwd);
        return new Response("更改密码成功");
    }

    @ResponseBody
    @PostMapping("detail")
    @WebLogger("查询用户详细")
    public Response detail(@RequestBody String userId) {
        Map user = userService.getDetail(userId);
        return new Response(user);
    }
    
    
	@RequestMapping(value = "/signature", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public boolean saveSignImg(@RequestParam("sign") String signFile,@RequestParam("userid") String userid)
			throws IllegalStateException, IOException {
		boolean result = false;
		User user = (User) UserContextUtil.getAttribute("currentUser");
		try {
			String account = user.getAccount();
			String imageDataBytes = signFile.substring(signFile.indexOf(",")+1);
			byte[] image = Base64.decodeBase64(imageDataBytes);
			String finalFilePath = fileService.getSignDir() + "/"
					+ userid;
			OutputStream stream = new FileOutputStream(finalFilePath);
			stream.write(image);
			stream.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	@GetMapping("/sign/{userid}")
	public void getSignImg(@PathVariable("userid") String userid,
			HttpServletResponse response) throws IOException {
		String filePath = fileService.getSignDir() + "/" + userid;
		File outputFile = new File(filePath);
		if (outputFile.exists()) {
			InputStream is = new FileInputStream(outputFile);
			int read = 0;
			byte[] bytes = new byte[BYTES_DOWNLOAD];
			OutputStream os = response.getOutputStream();
			while ((read = is.read(bytes)) != -1) {
				os.write(bytes, 0, read);
			}
			os.flush();
			os.close();
			is.close();
		}

	}
}
