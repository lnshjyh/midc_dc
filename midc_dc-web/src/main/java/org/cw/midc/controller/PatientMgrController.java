package org.cw.midc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cw.midc.ParamFilter;
import org.cw.midc.Response;
import org.cw.midc.model.DeviceType;
import org.cw.midc.model.DevicetypePositionCheckitem;
import org.cw.midc.page.Page;
import org.cw.midc.service.DevicetypePositionCheckitemService;
import org.cw.midc.service.ris.StudyInfoService;
import org.cw.midc.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("patlist")
public class PatientMgrController {
	
    @Resource
    private StudyInfoService studyInfoService;
    
    @Resource
    private DevicetypePositionCheckitemService devicetypePositionCheckitemService;
    
    @GetMapping("listPage")
    public String list() {
        return "patientList";
    }


	@ResponseBody
    @PostMapping("list")
    public Response list(@RequestBody  ParamFilter queryFilter) {

        List list = studyInfoService.queryList(queryFilter);
        Page page = queryFilter.getPage();
        return new Response(list,page);
    }
	
	@ResponseBody
    @PostMapping("bydevice")
    public  Response bydevice(@RequestBody String deviceTypeId) {
        List<DevicetypePositionCheckitem> list = devicetypePositionCheckitemService.findByDeviceType(deviceTypeId);
        return new Response(list);
    }
	
	@ResponseBody
    @PostMapping("bydevicepos")
    public  Response bydevicepos(@RequestBody  HashMap<String,Object> param) {
		String deviceTypeId = (String)param.get("deviceTypeId");
		String positiontypeId = (String)param.get("positiontypeId");
        List<DevicetypePositionCheckitem> list = devicetypePositionCheckitemService.findByDeviceTypeAndPositionType(deviceTypeId, Integer.parseInt(positiontypeId));
        return new Response(list);
    }
	
	@ResponseBody
    @GetMapping("devicetypes")
    public Response devicetypes() {
    	List<DeviceType> dlist =  devicetypePositionCheckitemService.getDeviceTypeList();
        return new Response(dlist);
    }
}
