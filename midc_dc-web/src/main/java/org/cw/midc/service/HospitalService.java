package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.dao.HospitalDao;
import org.cw.midc.entity.Hospital;
import org.cw.midc.page.Page;
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
    private HospitalDao hospitalDao;

    public List getList(ParamFilter param) {
        return hospitalDao.findMap("getList", param.getParam(), param.getPage());
    }

    @Transactional
    public void update(Hospital hospital) {
        checkNotNull(hospital, "医疗机构不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getHospName()), "医疗机构名不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getClientId()), "ClientId不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getHospId()), "hospId不能为空");
        hospitalDao.update("update",hospital);
    }

    @Transactional
    public void add(Hospital hospital) {
    	checkNotNull(hospital, "医疗机构不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getHospName()), "医疗机构名不能为空");
        checkArgument(!Strings.isNullOrEmpty(hospital.getClientId()), "ClientId不能为空");
        Hospital hosp = hospitalDao.findUnique("getByClientId", hospital.getClientId());
        checkArgument(hosp == null, "已存在该客户端标识");
        hospital.setClientSecret(CommonUtils.generateId());
        hospital.setCreateTime(new Date());
        hospital.setUpdateTime(new Date());
        hospital.setIsAvailable("1");
        hospital.setIsConnected("0");
        hospital.setHospId(CommonUtils.generateNumFive());

        hospitalDao.save(hospital);
    }


    public void delete(List<String> hospIds) {
    	checkArgument((hospIds != null && hospIds.size() > 0), "ID不能为空");
        for (String hospId : hospIds) {
        	hospitalDao.delete("delete", hospId);
        }
    }

    public Hospital getDetail(String hospId) {
    	Hospital hospital = hospitalDao.findUnique("getById", hospId);
        return hospital;
    }
    
    public List<Hospital> getAllHospitals()
    {
    	List<Hospital> result = (List<Hospital>)hospitalDao.find("getAll");
    	return result;
    }

}
