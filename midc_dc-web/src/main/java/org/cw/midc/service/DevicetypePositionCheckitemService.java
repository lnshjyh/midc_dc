package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.util.UserContextUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.entity.User;
import org.cw.midc.model.Checkitem;
import org.cw.midc.model.DevicetypePositionCheckitem;
import org.cw.midc.page.Page;
import org.cw.midc.repository.CheckitemRepository;
import org.cw.midc.repository.DevicetypePositionCheckitemRepository;
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
public class DevicetypePositionCheckitemService {

    @Resource
    private DevicetypePositionCheckitemRepository devicetypePositionCheckitemRepository;

    
    public org.springframework.data.domain.Page<DevicetypePositionCheckitem> getList(ParamFilter param) {
    	Page page = param.getPage();
    	int pageNo = page.getPageNo();
    	int pageSize = page.getPageSize();
    	PageRequest pageRequest = new PageRequest(pageNo-1, pageSize, new Sort(Sort.Direction.ASC, "createTime"));

        return devicetypePositionCheckitemRepository.findAll(pageRequest);
    }


    @Transactional
    public void add(DevicetypePositionCheckitem devicetypePositionCheckitem) {
    	checkNotNull(devicetypePositionCheckitem, "不能为空");
    	devicetypePositionCheckitem.setCreateTime(new Date());
    	devicetypePositionCheckitem.setUpdateTime(new Date());
    	User user = (User)UserContextUtil.getAttribute("currentUser");
    	devicetypePositionCheckitem.setOperId(user.getUserId());

    	devicetypePositionCheckitemRepository.save(devicetypePositionCheckitem);
    }


    public void delete(List<Integer> Ids) {
    	List<DevicetypePositionCheckitem> list = (List<DevicetypePositionCheckitem>)devicetypePositionCheckitemRepository.findAll(Ids);
    	devicetypePositionCheckitemRepository.delete(list);
    }


}
