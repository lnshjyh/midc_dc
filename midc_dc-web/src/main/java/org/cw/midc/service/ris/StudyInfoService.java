package org.cw.midc.service.ris;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.cw.midc.ParamFilter;
import org.cw.midc.dao.StudyInfoDao;
import org.cw.midc.page.Page;
import org.cw.midc.service.DevicetypePositionCheckitemService;
import org.springframework.stereotype.Service;

@Service
public class StudyInfoService {
	
	@Resource
    private StudyInfoDao studyInfoDao;
	

    public List getList(HashMap<String,Object> param) {
    	Page page = new Page();
    	page.setPageNo((int)param.get("pageNum"));
    	page.setPageSize((int)param.get("pageSize"));
    	String checkitemIdPk = (String)param.get("checkItem");
    	String positionIdPk = (String)param.get("position");
    	List<String> studyids = null;
    	if(StringUtils.isNotBlank(checkitemIdPk) || StringUtils.isNotBlank(positionIdPk)){
    		param.put("checkitemIdPk", checkitemIdPk);
    		param.put("positionIdPk", positionIdPk);
    		studyids = studyInfoDao.findColumn("getStudyInfoIdList", String.class, param);
    	}
    	
    	if(studyids != null && !studyids.isEmpty()){
    		param.put("studyids", studyids);
    	}
    	
        return studyInfoDao.findMap("getList", param, page);
    }
    
    public List queryList(ParamFilter param) {
    	Map<String, Object> paraMap = param.getParam();
    	
    	List<String> studyids = studyInfoDao.findColumn("getStudyInfoIdList", String.class, paraMap);
    	if(!studyids.isEmpty() && paraMap != null){
    		param.getParam().put("studyids", studyids);
    	}
    	
        return studyInfoDao.findMap("getList", param.getParam(), param.getPage());
    }
    
    public int getCount(HashMap<String,Object> param){
    	Page page = new Page();
    	page.setPageNo((int)param.get("pageNum"));
    	page.setPageSize((int)param.get("pageSize"));
    	String checkitemIdPk = (String)param.get("checkItem");
    	String positionIdPk = (String)param.get("position");
    	List<String> studyids = null;
    	if(StringUtils.isNotBlank(checkitemIdPk) || StringUtils.isNotBlank(positionIdPk)){
    		param.put("checkitemIdPk", checkitemIdPk);
    		param.put("positionIdPk", positionIdPk);
    		studyids = studyInfoDao.findColumn("getStudyInfoIdList", String.class, param);
    	}
    	
    	if(studyids != null && !studyids.isEmpty()){
    		param.put("studyids", studyids);
    	}
    	return studyInfoDao.getCount(param);
    }

}
