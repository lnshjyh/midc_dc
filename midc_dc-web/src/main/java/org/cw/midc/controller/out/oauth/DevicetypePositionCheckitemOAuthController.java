package org.cw.midc.controller.out.oauth;

import java.util.ArrayList;
import java.util.List;

import org.cw.midc.Response;
import org.cw.midc.entity.CheckItem;
import org.cw.midc.entity.DevicetypePositionCheckitem;
import org.cw.midc.entity.Positiontype;
import org.cw.midc.service.DevicetypePositionCheckitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/res/basic")
public class DevicetypePositionCheckitemOAuthController {
	
	@Autowired
	private DevicetypePositionCheckitemService devicetypePositionCheckitemService;
	
	@GetMapping("positions")
	public Response getPositionByDeviceType(@RequestParam("deviceTypeId") String deviceTypeId)
	{
		Response response = new Response();
		List<Positiontype> positionTypeList = new ArrayList<Positiontype>();
		List<DevicetypePositionCheckitem> result = devicetypePositionCheckitemService.findByDeviceType(deviceTypeId);
		result.forEach(item -> {
			positionTypeList.add(new Positiontype(item.getPositiontypeId(),item.getPositiontypename()));
		});
		response.setData(positionTypeList);
		return response;
	}
	
	@GetMapping("checkItems")
	public Response getCheckItemByDeviceTypeAndPositionType(@RequestParam("deviceTypeId") String deviceTypeId,
			@RequestParam("postionTypeId") String postionTypeId)
	{
		Response response = new Response();
		List<CheckItem> checkitemList = new ArrayList<CheckItem>();
		Integer postionTypeIdInt = Integer.parseInt(postionTypeId);
		List<DevicetypePositionCheckitem> result = devicetypePositionCheckitemService.findByDeviceTypeAndPositionType(deviceTypeId, postionTypeIdInt)
;
		result.forEach(item -> {
			checkitemList.add(new CheckItem(item.getCheckitemId(),item.getCheckitemname()));
		});
		response.setData(checkitemList);
		return response;
	}

}
