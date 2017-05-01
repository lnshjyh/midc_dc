package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.util.UserContextUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.dao.CheckItemDao;
import org.cw.midc.dao.DeviceTypeDao;
import org.cw.midc.dao.DevicetypePositionCheckitemDao;
import org.cw.midc.dao.PositionTypeDao;
import org.cw.midc.entity.CheckItem;
import org.cw.midc.entity.DeviceType;
import org.cw.midc.entity.DevicetypePositionCheckitem;
import org.cw.midc.entity.Positiontype;
import org.cw.midc.entity.User;
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
public class DevicetypePositionCheckitemService {

    @Resource
    private DevicetypePositionCheckitemDao devicetypePositionCheckitemDao;
    
    @Resource
    private CheckItemDao checkItemDao;
    
    @Resource
    private DeviceTypeDao deviceTypeDao;
    
    @Resource
    private PositionTypeDao positionTypeDao;
    
    

    
    public List getList(ParamFilter param) {

        return devicetypePositionCheckitemDao.findMap("getList",param.getParam(),param.getPage());
    }


    @Transactional
    public void add(DevicetypePositionCheckitem devicetypePositionCheckitem) {
    	checkNotNull(devicetypePositionCheckitem, "不能为空");
    	devicetypePositionCheckitem.setCreateTime(new Date());
    	devicetypePositionCheckitem.setUpdateTime(new Date());
    	User user = (User)UserContextUtil.getAttribute("currentUser");
    	devicetypePositionCheckitem.setOperId(user.getUserId());

    	devicetypePositionCheckitemDao.save(devicetypePositionCheckitem);
    }
    
    public List<DevicetypePositionCheckitem> findByDeviceType(String deviceTypeId){
    	Map<String, Object> para = Maps.newHashMap();
    	para.put("deviceTypeId", deviceTypeId);
    	return devicetypePositionCheckitemDao.find("getByDeviceTypeId", para);
    }
    
    public List<DevicetypePositionCheckitem> findByDeviceTypeAndPositionType(String deviceTypeId,Integer positiontypeId){
    	Map<String, Object> para = Maps.newHashMap();
    	para.put("deviceTypeId", deviceTypeId);
    	para.put("positiontypeId", positiontypeId);
    	return devicetypePositionCheckitemDao.find("getByDeviceTypeIdAndPositiontypeId", para);
    }


    public void delete(List<Integer> Ids) {
    	checkArgument((Ids != null && Ids.size() > 0), "ID不能为空");
        for (Integer id : Ids) {
        	devicetypePositionCheckitemDao.delete("deleteById", id);
        }
    }
    
    public List<CheckItem> getCheckitemList(){
    	return (List<CheckItem>)checkItemDao.find("getAll");
    }
    
    public List<DeviceType> getDeviceTypeList(){
    	return (List<DeviceType>)deviceTypeDao.find("getAll");
    }
    
    public List<Positiontype> getPositionTypeList(){
    	return (List<Positiontype>)positionTypeDao.find("getAll");
    }
    
    public CheckItem getCheckitem(Integer id){
    	return (CheckItem)checkItemDao.findUnique("getById", id);
    }
    
    public DeviceType getDeviceType(String id){
    	return (DeviceType)deviceTypeDao.findUnique("getById", id);
    }
    
    public Positiontype getPositionType(Integer id){
    	return (Positiontype)positionTypeDao.findUnique("getById", id);
    }



}
