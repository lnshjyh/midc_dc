package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.util.UserContextUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.entity.User;
import org.cw.midc.model.Checkitem;
import org.cw.midc.model.DeviceType;
import org.cw.midc.model.PositionType;
import org.cw.midc.page.Page;
import org.cw.midc.repository.CheckitemRepository;
import org.cw.midc.repository.DeviceTypeRepository;
import org.cw.midc.repository.PositionTypeRepository;
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
public class DeviceTypeService {

    @Resource
    private DeviceTypeRepository deviceTypeRepository;

    public List<DeviceType> getList(ParamFilter param) {
    	Page page = param.getPage();
    	int pageNo = page.getPageNo();
    	int pageSize = page.getPageSize();
    	Map<String,Object> para = param.getParam();
    	String deviceTypeName = para == null?null:(String)para.get("deviceTypeName");
    	PageRequest pageRequest = new PageRequest(pageNo-1, pageSize, new Sort(Sort.Direction.ASC, "createTime"));
        return deviceTypeName == null?(List<DeviceType>)deviceTypeRepository.findAll():deviceTypeRepository.findByDeviceTypeNameLike(deviceTypeName, pageRequest);
    }

    @Transactional
    public void update(DeviceType deviceType) {
        checkNotNull(deviceType, "设备类型不能为空");
        checkArgument(!Strings.isNullOrEmpty(deviceType.getDeviceTypeName()), "设备类型名不能为空");
        checkArgument(!Strings.isNullOrEmpty(deviceType.getDeviceTypeId()), "设备类型ID不能为空");
        deviceTypeRepository.updateByID(deviceType.getDeviceTypeName(),
        		deviceType.getIsAvailable(),deviceType.getOperId(),new Date(),
        		deviceType.getDeviceTypeId());
    }

    @Transactional
    public void add(DeviceType deviceType) {
    	checkNotNull(deviceType, "设备类型不能为空");
        checkArgument(!Strings.isNullOrEmpty(deviceType.getDeviceTypeName()), "设备名不能为空");
        deviceType.setCreateTime(new Date());
        deviceType.setUpdateTime(new Date());
        deviceType.setIsAvailable("1");
    	User user = (User)UserContextUtil.getAttribute("currentUser");
    	deviceType.setOperId(user.getUserId());

    	deviceTypeRepository.save(deviceType);
    }


    public void delete(List<String> deviceTypeIds) {
    	List<DeviceType> list = (List<DeviceType>)deviceTypeRepository.findAll(deviceTypeIds);
    	deviceTypeRepository.delete(list);
    }

    public DeviceType getDetail(String deviceTypeId) {
    	DeviceType deviceType = deviceTypeRepository.findOne(deviceTypeId);
        return deviceType;
    }

}
