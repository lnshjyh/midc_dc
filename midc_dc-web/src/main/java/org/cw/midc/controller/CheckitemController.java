package org.cw.midc.controller;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import org.cw.midc.Response;
import org.cw.midc.page.Page;
import org.cw.midc.ParamFilter;
import org.cw.midc.aop.annotaion.WebLogger;
import org.cw.midc.entity.CheckItem;
import org.cw.midc.entity.User;
import org.cw.midc.service.CheckitemService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Controller
@RequestMapping("checkitem")
public class CheckitemController {

    @Resource
    private CheckitemService checkitemService;

    @GetMapping("listPage")
    public String list() {
        return "checkitemList";
    }


    @ResponseBody
    @PostMapping("list")
    public Response list(@RequestBody  ParamFilter queryFilter) {
        List checkitemList = checkitemService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(checkitemList,page);
    }

    @ResponseBody
    @PostMapping("add")
    public Response add(@RequestBody CheckItem checkitem) {
        checkNotNull(checkitem, "检查项不能为空");
        checkitemService.add(checkitem);
        return new Response("添加成功");
    }


    @ResponseBody
    @PostMapping("edit")
    public Response edit(@RequestBody CheckItem checkitem) {
    	checkitemService.update(checkitem);
        return new Response("修改成功");
    }

    @ResponseBody
    @PostMapping("delete")
    public Response delete(@RequestBody List<Integer> checkitemIds) {
        checkArgument((checkitemIds != null && checkitemIds.size() > 0), "检查项ID不能为空");
        checkitemService.delete(checkitemIds);
        return new Response("删除成功");
    }


    @ResponseBody
    @PostMapping("detail")
    public Response detail(@RequestBody Integer checkitemId) {
    	CheckItem checkitem = checkitemService.getDetail(checkitemId);
        return new Response(checkitem);
    }
}
