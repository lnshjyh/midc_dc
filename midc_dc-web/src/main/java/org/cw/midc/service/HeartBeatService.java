package org.cw.midc.service;

import java.util.Date;
import java.util.List;

import org.cw.midc.model.Hospital;
import org.cw.midc.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartBeatService {
	
	@Autowired
	private HospitalRepository hospitalRepository;
	
	public void updateLastHeartBeatTime(String clientId)
	{
		List<Hospital> hospitals = hospitalRepository.findByClientId(clientId);
		Date lastHBTime = new Date();
		hospitals.forEach(hospital -> {
			hospital.setLastHbTime(lastHBTime);
			hospitalRepository.save(hospital);
		});
	}

}
