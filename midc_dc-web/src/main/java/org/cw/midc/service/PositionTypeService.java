package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.util.UserContextUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.entity.User;
import org.cw.midc.model.Checkitem;
import org.cw.midc.model.PositionType;
import org.cw.midc.page.Page;
import org.cw.midc.repository.CheckitemRepository;
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
public class PositionTypeService {

    @Resource
    private PositionTypeRepository positionTypeRepository;

    public List<PositionType> getList(ParamFilter param) {
    	Page page = param.getPage();
    	int pageNo = page.getPageNo();
    	int pageSize = page.getPageSize();
    	Map<String,Object> para = param.getParam();
    	String positiontypeName = para == null?null:(String)para.get("positiontypeName");
    	PageRequest pageRequest = new PageRequest(pageNo-1, pageSize, new Sort(Sort.Direction.ASC, "createTime"));
        return positiontypeName == null?(List<PositionType>)positionTypeRepository.findAll():positionTypeRepository.findByPositiontypeNameLike(positiontypeName, pageRequest);
    }

    @Transactional
    public void update(PositionType positionType) {
        checkNotNull(positionType, "检查部位不能为空");
        checkArgument(!Strings.isNullOrEmpty(positionType.getPositiontypeName()), "部位名不能为空");
        positionTypeRepository.updateByID(positionType.getPositiontypeName(),
        		positionType.getIsAvailable(),positionType.getOperId(),new Date(),
        		positionType.getPositiontypeId());
    }

    @Transactional
    public void add(PositionType positionType) {
    	checkNotNull(positionType, "检查部位不能为空");
        checkArgument(!Strings.isNullOrEmpty(positionType.getPositiontypeName()), "部位名不能为空");
        positionType.setCreateTime(new Date());
        positionType.setUpdateTime(new Date());
        positionType.setIsAvailable("1");
    	User user = (User)UserContextUtil.getAttribute("currentUser");
    	positionType.setOperId(user.getUserId());

    	positionTypeRepository.save(positionType);
    }


    public void delete(List<Integer> positiontypeIds) {
    	List<PositionType> list = (List<PositionType>)positionTypeRepository.findAll(positiontypeIds);
    	positionTypeRepository.delete(list);
    }

    public PositionType getDetail(Integer positiontypeId) {
    	PositionType positionType = positionTypeRepository.findOne(positiontypeId);
        return positionType;
    }

}
