package org.cw.midc.controller.out;

import java.util.ArrayList;
import java.util.List;

import org.cw.midc.Response;
import org.cw.midc.dto.DeviceTypeQueryDto;
import org.cw.midc.dto.HospitalQueryDto;
import org.cw.midc.model.DeviceType;
import org.cw.midc.service.DeviceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/out")
public class DeviceTypeRestController {
	
	@Autowired
	private DeviceTypeService deviceTypeService;
	
	@GetMapping("deviceTypes")
	public Response getDeviceTypes()
	{
		List<DeviceType> deviceTypes = deviceTypeService.getAllDeviceTypes();
		Response response = new Response();
		List<DeviceTypeQueryDto> result = new ArrayList<DeviceTypeQueryDto>();
		deviceTypes.forEach(deviceType -> {
			DeviceTypeQueryDto deviceTypeQueryDto = new DeviceTypeQueryDto();
			deviceTypeQueryDto.setDeviceTypeId(deviceType.getDeviceTypeId());
			deviceTypeQueryDto.setDeviceTypeName(deviceType.getDeviceTypeName());
			result.add(deviceTypeQueryDto);
		});
		response.setData(result);
		return response;
	}

}
