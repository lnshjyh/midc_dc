package org.cw.midc.controller;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.cw.midc.Response;
import org.cw.midc.page.Page;
import org.cw.midc.ParamFilter;
import org.cw.midc.aop.annotaion.WebLogger;
import org.cw.midc.entity.StorageInfo;
import org.cw.midc.service.StorageService;
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
@RequestMapping("storage")
public class StorageController {

    @Resource
    private StorageService storageService;

    @GetMapping("listPage")
    public String list() {
        return "storageList";
    }


    @ResponseBody
    @PostMapping("list")
    public Response list(@RequestBody  ParamFilter queryFilter) {
        List list = storageService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(list,page);
    }

    @ResponseBody
    @PostMapping("add")
    public Response add(@RequestBody StorageInfo storageInfo) {
        checkNotNull(storageInfo, "不能为空");
        storageService.add(storageInfo);
        return new Response("添加成功");
    }


    
    @ResponseBody
    @PostMapping("delete")
    public Response delete(@RequestBody List<String> storageIds) {
        checkArgument((storageIds != null && storageIds.size() > 0), "存储ID不能为空");
        storageService.delete(storageIds);
        return new Response("删除成功");
    }

}
