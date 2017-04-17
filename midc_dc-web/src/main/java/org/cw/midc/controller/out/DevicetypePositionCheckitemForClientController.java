package org.cw.midc.controller.out;

import java.util.ArrayList;
import java.util.List;

import org.cw.midc.Response;
import org.cw.midc.model.Checkitem;
import org.cw.midc.model.DevicetypePositionCheckitem;
import org.cw.midc.model.PositionType;
import org.cw.midc.service.DevicetypePositionCheckitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/out")
public class DevicetypePositionCheckitemForClientController {
	
	@Autowired
	private DevicetypePositionCheckitemService devicetypePositionCheckitemService;
	
	@GetMapping("positions")
	public Response getPositionByDeviceType(@RequestParam("deviceTypeId") String deviceTypeId)
	{
		Response response = new Response();
		List<PositionType> positionTypeList = new ArrayList<PositionType>();
		List<DevicetypePositionCheckitem> result = devicetypePositionCheckitemService.findByDeviceType(deviceTypeId);
		result.forEach(item -> {
			positionTypeList.add(item.getPositionType());
		});
		response.setData(positionTypeList);
		return response;
	}
	
	@GetMapping("checkItems")
	public Response getCheckItemByDeviceTypeAndPositionType(@RequestParam("deviceTypeId") String deviceTypeId,
			@RequestParam("postionTypeId") String postionTypeId)
	{
		Response response = new Response();
		List<Checkitem> checkitemList = new ArrayList<Checkitem>();
		Integer postionTypeIdInt = Integer.parseInt(postionTypeId);
		List<DevicetypePositionCheckitem> result = devicetypePositionCheckitemService.findByDeviceTypeAndPositionType(deviceTypeId, postionTypeIdInt)
;
		result.forEach(item -> {
			checkitemList.add(item.getCheckitem());
		});
		response.setData(checkitemList);
		return response;
	}

}
