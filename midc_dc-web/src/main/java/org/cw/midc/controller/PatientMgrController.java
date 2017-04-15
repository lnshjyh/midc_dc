package org.cw.midc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cw.midc.service.ris.StudyInfoService;
import org.cw.midc.util.CommonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("patlist")
public class PatientMgrController {
	
    @Resource
    private StudyInfoService studyInfoService;


	@ResponseBody
    @PostMapping("list")
    public Map<String,Object> list(@RequestBody  HashMap<String,Object> param) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(param.get("pageNum") == null  ){
			return map;
		}
		if(param.get("pageSize") == null ){
			return map;
		}

        List list = studyInfoService.getList(param);
        map.put("patientList", list);
        map.put("totalNum", studyInfoService.getCount(param));
        return map;
    }
}
