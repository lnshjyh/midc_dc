package org.cw.midc.controller;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import org.cw.midc.Response;
import org.cw.midc.page.Page;
import org.cw.midc.ParamFilter;
import org.cw.midc.aop.annotaion.WebLogger;
import org.cw.midc.entity.User;
import org.cw.midc.model.Checkitem;
import org.cw.midc.model.DeviceType;
import org.cw.midc.model.DevicetypePositionCheckitem;
import org.cw.midc.model.Hospital;
import org.cw.midc.model.PositionType;
import org.cw.midc.service.CheckitemService;
import org.cw.midc.service.DevicetypePositionCheckitemService;
import org.cw.midc.service.HospitalService;
import org.cw.midc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

@Controller
@RequestMapping("devicetypePositionCheckitem")
public class DevicetypePositionCheckitemController {

    @Resource
    private DevicetypePositionCheckitemService devicetypePositionCheckitemService;

    @GetMapping("listPage")
    public String list() {
        return "devicetypePositionCheckitemList";
    }


    @ResponseBody
    @PostMapping("list")
    @WebLogger("查询列表")
    public Response list(@RequestBody  ParamFilter queryFilter) {
    	org.springframework.data.domain.Page<DevicetypePositionCheckitem> pageD = devicetypePositionCheckitemService.getList(queryFilter);
    	List<DevicetypePositionCheckitem> list = pageD.getContent();
        Page page = queryFilter.getPage();
        return new Response(list,page);
    }

    @ResponseBody
    @PostMapping("add")
    @WebLogger("添加设备关联")
    public Response add(@RequestBody DevicetypePositionCheckitem devicetypePositionCheckitem) {
        checkNotNull(devicetypePositionCheckitem, "不能为空");
        devicetypePositionCheckitemService.add(devicetypePositionCheckitem);
        return new Response("添加成功");
    }



    @ResponseBody
    @PostMapping("delete")
    @WebLogger("删除设备关联")
    public Response delete(@RequestBody List<Integer> Ids) {
        checkArgument((Ids != null && Ids.size() > 0), "ID不能为空");
        devicetypePositionCheckitemService.delete(Ids);
        return new Response("删除成功");
    }
    
    @ResponseBody
    @PostMapping("basicdata")
    public Map<String,Object> basicdata() {
    	List<Checkitem>  clist = devicetypePositionCheckitemService.getCheckitemList();
    	List<DeviceType> dlist =  devicetypePositionCheckitemService.getDeviceTypeList();
    	List<PositionType> plist = devicetypePositionCheckitemService.getPositionTypeList();
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("c", clist);
    	map.put("d", dlist);
    	map.put("p", plist);
        return map;
    }


}
