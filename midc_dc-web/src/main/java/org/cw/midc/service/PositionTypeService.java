package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.util.UserContextUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.dao.PositionTypeDao;
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
public class PositionTypeService {

    @Resource
    private PositionTypeDao positionTypeDao;

    public List getList(ParamFilter param) {
        return positionTypeDao.findMap("getList", param.getParam(), param.getPage());
    }

    @Transactional
    public void update(Positiontype positionType) {
        checkNotNull(positionType, "检查部位不能为空");
        checkArgument(!Strings.isNullOrEmpty(positionType.getPositiontypeName()), "部位名不能为空");
        positionTypeDao.update(positionType);
    }

    @Transactional
    public void add(Positiontype positionType) {
    	checkNotNull(positionType, "检查部位不能为空");
        checkArgument(!Strings.isNullOrEmpty(positionType.getPositiontypeName()), "部位名不能为空");
        positionType.setCreateTime(new Date());
        positionType.setUpdateTime(new Date());
        positionType.setIsAvailable("1");
    	User user = (User)UserContextUtil.getAttribute("currentUser");
    	positionType.setOperId(user.getUserId());

    	positionTypeDao.save(positionType);
    }


    public void delete(List<Integer> positiontypeIds) {
    	checkArgument((positiontypeIds != null && positiontypeIds.size() > 0), "ID不能为空");
        for (Integer positiontypeId : positiontypeIds) {
        	positionTypeDao.delete("deleteById", positiontypeId);
        }
    }

    public Positiontype getDetail(Integer positiontypeId) {
    	Positiontype positionType = positionTypeDao.findUnique("getById", positiontypeId);
        return positionType;
    }

}
