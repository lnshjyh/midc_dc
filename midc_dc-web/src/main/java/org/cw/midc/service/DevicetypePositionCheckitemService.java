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
import org.cw.midc.model.DevicetypePositionCheckitem;
import org.cw.midc.model.PositionType;
import org.cw.midc.page.Page;
import org.cw.midc.repository.CheckitemRepository;
import org.cw.midc.repository.DeviceTypeRepository;
import org.cw.midc.repository.DevicetypePositionCheckitemRepository;
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
public class DevicetypePositionCheckitemService {

    @Resource
    private DevicetypePositionCheckitemRepository devicetypePositionCheckitemRepository;
    
    @Resource
    private CheckitemRepository checkitemRepository;
    
    @Resource
    private DeviceTypeRepository deviceTypeRepository;
    
    @Resource
    private PositionTypeRepository positionTypeRepository;
    
    

    
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
    
    public List<DevicetypePositionCheckitem> findByDeviceType(String deviceTypeId){
    	DeviceType deviceType = (DeviceType)deviceTypeRepository.findOne(deviceTypeId);
    	return devicetypePositionCheckitemRepository.findByDevice(deviceType);
    }
    
    public List<DevicetypePositionCheckitem> findByDeviceTypeAndPositionType(String deviceTypeId,Integer positiontypeId){
    	DeviceType deviceType = (DeviceType)deviceTypeRepository.findOne(deviceTypeId);
    	PositionType positionType = (PositionType)positionTypeRepository.findOne(positiontypeId);
    	return devicetypePositionCheckitemRepository.findByDeviceAndPositionType(deviceType, positionType);
    }


    public void delete(List<Integer> Ids) {
    	List<DevicetypePositionCheckitem> list = (List<DevicetypePositionCheckitem>)devicetypePositionCheckitemRepository.findAll(Ids);
    	devicetypePositionCheckitemRepository.delete(list);
    }
    
    public List<Checkitem> getCheckitemList(){
    	return (List<Checkitem>)checkitemRepository.findAll();
    }
    
    public List<DeviceType> getDeviceTypeList(){
    	return (List<DeviceType>)deviceTypeRepository.findAll();
    }
    
    public List<PositionType> getPositionTypeList(){
    	return (List<PositionType>)positionTypeRepository.findAll();
    }
    
    public Checkitem getCheckitem(Integer id){
    	return (Checkitem)checkitemRepository.findOne(id);
    }
    
    public DeviceType getDeviceType(String id){
    	return (DeviceType)deviceTypeRepository.findOne(id);
    }
    
    public PositionType getPositionType(Integer id){
    	return (PositionType)positionTypeRepository.findOne(id);
    }



}
