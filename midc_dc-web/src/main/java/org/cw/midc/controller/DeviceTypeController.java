package org.cw.midc.controller;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import org.cw.midc.Response;
import org.cw.midc.page.Page;
import org.cw.midc.ParamFilter;
import org.cw.midc.aop.annotaion.WebLogger;
import org.cw.midc.entity.DeviceType;
import org.cw.midc.service.DeviceTypeService;
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
@RequestMapping("deviceType")
public class DeviceTypeController {

    @Resource
    private DeviceTypeService deviceTypeService;

    @GetMapping("listPage")
    public String list() {
        return "deviceTypeList";
    }


    @ResponseBody
    @PostMapping("list")
    public Response list(@RequestBody  ParamFilter queryFilter) {
        List deviceTypeList = deviceTypeService.getList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(deviceTypeList,page);
    }

    @ResponseBody
    @PostMapping("add")
    public Response add(@RequestBody DeviceType deviceType) {
        checkNotNull(deviceType, "设备类型不能为空");
        deviceTypeService.add(deviceType);
        return new Response("添加成功");
    }


    @ResponseBody
    @PostMapping("edit")
    public Response edit(@RequestBody DeviceType deviceType) {
    	deviceTypeService.update(deviceType);
        return new Response("修改成功");
    }

    @ResponseBody
    @PostMapping("delete")
    public Response delete(@RequestBody List<String> deviceTypeIds) {
        checkArgument((deviceTypeIds != null && deviceTypeIds.size() > 0), "设备ID不能为空");
        deviceTypeService.delete(deviceTypeIds);
        return new Response("删除成功");
    }


    @ResponseBody
    @PostMapping("detail")
    public Response detail(@RequestBody String deviceTypeId) {
    	DeviceType deviceType = deviceTypeService.getDetail(deviceTypeId);
        return new Response(deviceType);
    }
}
