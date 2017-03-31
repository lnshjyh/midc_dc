package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.model.Hospital;
import org.cw.midc.page.Page;
import org.cw.midc.repository.HospitalRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class HospitalService {

    @Resource
    private HospitalRepository hospitalRepository;

    public List<Hospital> getList(ParamFilter param) {
    	Page page = param.getPage();
    	int pageNo = page.getPageNo();
    	int pageSize = page.getPageSize();
    	Map<String,Object> para = param.getParam();
    	String hospName = para == null?null:(String)para.get("hospName");
    	PageRequest pageRequest = new PageRequest(pageNo-1, pageSize, new Sort(Sort.Direction.ASC, "createTime"));
        return hospName == null?(List<Hospital>)hospitalRepository.findAll():hospitalRepository.findByHospNameLike(hospName, pageRequest);
    }

    @Transactional
    public void update(Hospital hospital) {
        checkNotNull(hospital, "医疗机构不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getHospName()), "医疗机构名不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getClientId()), "ClientId不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getHospId()), "hospId不能为空");
        hospitalRepository.updateByID(hospital.getClientId(),
        		hospital.getHospName(),hospital.getAddress(),hospital.getLongitude(),
        		hospital.getLatitude(),hospital.getHospId());
    }

    @Transactional
    public void add(Hospital hospital) {
    	checkNotNull(hospital, "医疗机构不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getHospName()), "医疗机构名不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getClientId()), "ClientId不能为空");
        hospital.setClientSecret(CommonUtils.generateId());
        hospital.setCreateTime(new Date());
        hospital.setUpdateTime(new Date());
        hospital.setIsAvailable("1");
        hospital.setIsConnected("0");
        hospital.setHospId(CommonUtils.generateId());

        hospitalRepository.save(hospital);
    }


    public void delete(List<String> hospIds) {
    	List<Hospital> list = (List<Hospital>)hospitalRepository.findAll(hospIds);
    	hospitalRepository.delete(list);
    }

    public Hospital getDetail(String hospId) {
    	Hospital hospital = hospitalRepository.findOne(hospId);
        return hospital;
    }
    
    public List<Hospital> getAllHospitals()
    {
    	List<Hospital> result = (List<Hospital>)hospitalRepository.findAll();
    	return result;
    }

}
