package org.cw.midc.controller.out.oauth;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.cw.midc.util.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/res/basic/user")
public class UserOAuthController {
	
    @Resource
    private FileService fileService;
    
	private static final int BYTES_DOWNLOAD = 4096;
	private static final int MINIWIDTH = 200;
	private static final int MINIHEIGHT = 100;
	
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
