package org.cw.midc.controller;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import org.cw.midc.Response;
import org.cw.midc.page.Page;
import org.cw.midc.ParamFilter;
import org.cw.midc.aop.annotaion.WebLogger;
import org.cw.midc.entity.User;
import org.cw.midc.model.Hospital;
import org.cw.midc.service.HospitalService;
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
@RequestMapping("hospital")
public class HospitalController {

    @Resource
    private HospitalService hospitalService;

    @GetMapping("listPage")
    public String list() {
        return "hospitalList";
    }


    @ResponseBody
    @PostMapping("list")
    @WebLogger("查询医疗机构列表")
    public Response list(@RequestBody  ParamFilter queryFilter) {
        List hosList = hospitalService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(hosList,page);
    }

    @ResponseBody
    @PostMapping("add")
    @WebLogger("添加医疗机构")
    public Response add(@RequestBody Hospital hospital) {
        checkNotNull(hospital, "用户不能为空");
        hospitalService.add(hospital);
        return new Response("添加成功");
    }


    @ResponseBody
    @PostMapping("edit")
    @WebLogger("编辑医疗机构")
    public Response edit(@RequestBody Hospital hospital) {
    	hospitalService.update(hospital);
        return new Response("修改成功");
    }

    @ResponseBody
    @PostMapping("delete")
    @WebLogger("删除医疗机构")
    public Response delete(@RequestBody List<String> hospIds) {
        checkArgument((hospIds != null && hospIds.size() > 0), "用户编号不能为空");
        hospitalService.delete(hospIds);
        return new Response("删除成功");
    }


    @ResponseBody
    @PostMapping("detail")
    @WebLogger("查询医疗机构详细")
    public Response detail(@RequestBody String hospId) {
    	Hospital hospital = hospitalService.getDetail(hospId);
        return new Response(hospital);
    }
}
