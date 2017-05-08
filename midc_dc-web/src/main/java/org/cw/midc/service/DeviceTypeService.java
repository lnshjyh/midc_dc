package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.util.UserContextUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.dao.DeviceTypeDao;
import org.cw.midc.entity.DeviceType;
import org.cw.midc.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class DeviceTypeService {

    @Resource
    private DeviceTypeDao deviceTypeDao;

    public List getList(ParamFilter param) {
        return deviceTypeDao.findMap("getList",param.getParam(),param.getPage());
    }

    @Transactional
    public void update(DeviceType deviceType) {
        checkNotNull(deviceType, "设备类型不能为空");
        checkArgument(!Strings.isNullOrEmpty(deviceType.getDeviceTypeName()), "设备类型名不能为空");
        checkArgument(!Strings.isNullOrEmpty(deviceType.getDeviceTypeId()), "设备类型ID不能为空");
        deviceTypeDao.update(deviceType);;
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
    	deviceType.setDeviceTypeId(CommonUtils.generateNumFive());

    	deviceTypeDao.save(deviceType);
    }


    public void delete(List<String> deviceTypeIds) {
    	checkArgument((deviceTypeIds != null && deviceTypeIds.size() > 0), "ID不能为空");
    	for (String deviceTypeId : deviceTypeIds) {
    		deviceTypeDao.delete("deleteById", deviceTypeId);
        }
    }

    public DeviceType getDetail(String deviceTypeId) {
    	DeviceType deviceType = deviceTypeDao.findUnique("getById", deviceTypeId);
        return deviceType;
    }
    
    public List<DeviceType> getAllDeviceTypes()
    {
    	List<DeviceType> deviceTypes = (List<DeviceType>)deviceTypeDao.find("getAll");
        return deviceTypes;
    }

}
