package org.cw.midc.controller;

import org.cw.midc.Response;
import org.cw.midc.page.Page;
import org.cw.midc.ParamFilter;
import org.cw.midc.entity.WebLog;
import org.cw.midc.service.WebLogService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import javax.annotation.Resource;


@Controller
@RequestMapping("webLog")
public class WebLogController {

    @Resource
    private WebLogService webLogService;

    @GetMapping("list")
    public String list(){
        return "webLogList";
    }

    @ResponseBody
    @PostMapping("list")
    public Response list(@RequestBody ParamFilter queryFilter){
        List<WebLog> webLogList = webLogService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(webLogList,page);
    }
}
