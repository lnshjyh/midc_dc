package org.cw.midc.controller.out;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cw.midc.service.ris.StudyInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("out")
public class StudyInfoController {
	
    @Resource
    private StudyInfoService studyInfoService;


	@ResponseBody
    @PostMapping("studyinfos")
    public Map<String,Object> list(@RequestBody  HashMap<String,Object> paras) {
		Map<String,Object> map = new HashMap<String,Object>();
        List list = studyInfoService.getList(paras);
        map.put("patientList", list);
        map.put("totalNum", studyInfoService.getCount(paras));
        return map;
    }
}
