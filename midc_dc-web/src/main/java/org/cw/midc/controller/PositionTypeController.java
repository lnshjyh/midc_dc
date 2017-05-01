package org.cw.midc.controller;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import org.cw.midc.Response;
import org.cw.midc.page.Page;
import org.cw.midc.ParamFilter;
import org.cw.midc.aop.annotaion.WebLogger;
import org.cw.midc.entity.User;
import org.cw.midc.model.PositionType;
import org.cw.midc.service.HospitalService;
import org.cw.midc.service.PositionTypeService;
import org.cw.midc.service.UserService;

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
@RequestMapping("positionType")
public class PositionTypeController {

    @Resource
    private PositionTypeService positionTypeService;

    @GetMapping("listPage")
    public String list() {
        return "positionTypeList";
    }


    @ResponseBody
    @PostMapping("list")
    @WebLogger("查询部位列表")
    public Response list(@RequestBody  ParamFilter queryFilter) {
        List positionTypeList = positionTypeService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(positionTypeList,page);
    }

    @ResponseBody
    @PostMapping("add")
    @WebLogger("添加检查部位")
    public Response add(@RequestBody PositionType positionType) {
        checkNotNull(positionType, "检查部位不能为空");
        positionTypeService.add(positionType);
        return new Response("添加成功");
    }


    @ResponseBody
    @PostMapping("edit")
    @WebLogger("编辑检查部位")
    public Response edit(@RequestBody PositionType positionType) {
    	positionTypeService.update(positionType);
        return new Response("修改成功");
    }

    @ResponseBody
    @PostMapping("delete")
    @WebLogger("删除检查部位")
    public Response delete(@RequestBody List<Integer> positiontypeIds) {
        checkArgument((positiontypeIds != null && positiontypeIds.size() > 0), "部位ID不能为空");
        positionTypeService.delete(positiontypeIds);
        return new Response("删除成功");
    }


    @ResponseBody
    @PostMapping("detail")
    @WebLogger("查询检查部位详细")
    public Response detail(@RequestBody Integer positiontypeId) {
    	PositionType positionType = positionTypeService.getDetail(positiontypeId);
        return new Response(positionType);
    }
}
