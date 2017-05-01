package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.util.UserContextUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.dao.CheckItemDao;
import org.cw.midc.entity.CheckItem;
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
public class CheckitemService {

    @Resource
    private CheckItemDao checkitemDao;

    public List getList(ParamFilter param) {
        return checkitemDao.findMap("getList", param.getParam(), param.getPage());
    }

    @Transactional
    public void update(CheckItem checkitem) {
        checkNotNull(checkitem, "检查项不能为空");
        checkArgument(!Strings.isNullOrEmpty(checkitem.getCheckitemName()), "检查名不能为空");
        checkitemDao.update(checkitem);;
    }

    @Transactional
    public void add(CheckItem checkitem) {
    	checkNotNull(checkitem, "检查项不能为空");
    	checkArgument(!Strings.isNullOrEmpty(checkitem.getCheckitemName()), "检查名不能为空");
    	checkitem.setCreateTime(new Date());
    	checkitem.setUpdateTime(new Date());
    	checkitem.setIsAvailable("1");
    	User user = (User)UserContextUtil.getAttribute("currentUser");
    	checkitem.setOperId(user.getUserId());

    	checkitemDao.save(checkitem);
    }


    public void delete(List<Integer> checkitemIds) {
    	checkArgument((checkitemIds != null && checkitemIds.size() > 0), "用户编号不能为空");
        for (Integer checkitemId : checkitemIds) {
        	checkitemDao.delete("deleteById", checkitemId);
        }
    }

    public CheckItem getDetail(Integer checkitemId) {
    	CheckItem checkitem = checkitemDao.findUnique("getById", checkitemId);
        return checkitem;
    }

}
