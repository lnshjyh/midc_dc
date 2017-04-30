package org.cw.midc.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.cw.midc.dao.HospitalDao;
import org.cw.midc.entity.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartBeatService {
	
	@Autowired
	private HospitalDao hospitalDao;
	
	public void updateLastHeartBeatTime(String clientId)
	{
		List<Hospital> hospitalList = hospitalDao.find("getByClientId", clientId);
		hospitalList.forEach(hospital -> {
			Map<String, Object> param = new HashMap<>();
			param.put("lastHbTime", new Date());
			param.put("hospId", hospital.getHospId());
			hospitalDao.update("updateHeartBeatTime", param);
		});
	}

}
