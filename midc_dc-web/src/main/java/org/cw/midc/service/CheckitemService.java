package org.cw.midc.service;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import org.cw.midc.util.CommonUtils;
import org.cw.midc.util.RegexUtil;
import org.cw.midc.util.UserContextUtil;
import org.cw.midc.ParamFilter;
import org.cw.midc.entity.User;
import org.cw.midc.model.Checkitem;
import org.cw.midc.page.Page;
import org.cw.midc.repository.CheckitemRepository;
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
    private CheckitemRepository checkitemRepository;

    public List<Checkitem> getList(ParamFilter param) {
    	Page page = param.getPage();
    	int pageNo = page.getPageNo();
    	int pageSize = page.getPageSize();
    	Map<String,Object> para = param.getParam();
    	String checkitemName = para == null?null:(String)para.get("checkitemName");
    	PageRequest pageRequest = new PageRequest(pageNo-1, pageSize, new Sort(Sort.Direction.ASC, "createTime"));
        return checkitemName == null?(List<Checkitem>)checkitemRepository.findAll():checkitemRepository.findByCheckitemNameLike(checkitemName, pageRequest);
    }

    @Transactional
    public void update(Checkitem checkitem) {
        checkNotNull(checkitem, "检查项不能为空");
        checkArgument(!Strings.isNullOrEmpty(checkitem.getCheckitemName()), "检查名不能为空");
        checkitemRepository.updateByID(checkitem.getCheckitemName(),
        		checkitem.getIsAvailable(),checkitem.getOperId(),new Date(),
        		checkitem.getCheckitemId());
    }

    @Transactional
    public void add(Checkitem checkitem) {
    	checkNotNull(checkitem, "检查项不能为空");
    	checkArgument(!Strings.isNullOrEmpty(checkitem.getCheckitemName()), "检查名不能为空");
    	checkitem.setCreateTime(new Date());
    	checkitem.setUpdateTime(new Date());
    	checkitem.setIsAvailable("1");
    	User user = (User)UserContextUtil.getAttribute("currentUser");
    	checkitem.setOperId(user.getUserId());

    	checkitemRepository.save(checkitem);
    }


    public void delete(List<Integer> checkitemIds) {
    	List<Checkitem> list = (List<Checkitem>)checkitemRepository.findAll(checkitemIds);
    	checkitemRepository.delete(list);
    }

    public Checkitem getDetail(Integer checkitemId) {
    	Checkitem checkitem = checkitemRepository.findOne(checkitemId);
        return checkitem;
    }

}
