package org.cw.midc.controller.out;

import java.util.ArrayList;
import java.util.List;

import org.cw.midc.Response;
import org.cw.midc.dto.HospitalQueryDto;
import org.cw.midc.dto.ReportQueryDto;
import org.cw.midc.model.Hospital;
import org.cw.midc.service.HospitalService;
import org.cw.midc.service.factory.DozerBeanMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/out")
public class HospitalRestController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping("hospitals")
	public Response getAllHospitals()
	{
		List<Hospital> hospitals = hospitalService.getAllHospitals();
		Response response = new Response();
		List<HospitalQueryDto> result = new ArrayList<HospitalQueryDto>();
		hospitals.forEach(hospital -> {
			HospitalQueryDto hospitalQueryDto = new HospitalQueryDto();
			hospitalQueryDto.setHospitalId(hospital.getHospId());
			hospitalQueryDto.setHospitalName(hospital.getHospName());
			result.add(hospitalQueryDto);
		});
		response.setData(result);
		return response;
	}
	

}
