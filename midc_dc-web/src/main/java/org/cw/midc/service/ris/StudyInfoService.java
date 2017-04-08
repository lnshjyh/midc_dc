package org.cw.midc.service.ris;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.cw.midc.dao.StudyInfoDao;
import org.cw.midc.page.Page;
import org.springframework.stereotype.Service;

@Service
public class StudyInfoService {
	
	@Resource
    private StudyInfoDao studyInfoDao;

    public List getList(HashMap<String,Object> param) {
    	Page page = new Page();
    	page.setPageNo((int)param.get("pageNum"));
    	page.setPageSize((int)param.get("pageSize"));
    	List<String> studyids = studyInfoDao.findColumn("getStudyInfoIdList", String.class, param);
    	param.put("studyids", studyids);
        return studyInfoDao.findMap("getList", param, page);
    }
    
    public int getCount(HashMap<String,Object> param){
    	List<String> studyids = studyInfoDao.findColumn("getStudyInfoIdList", String.class, param);
    	param.put("studyids", studyids);
    	return studyInfoDao.getCount(param);
    }

}
