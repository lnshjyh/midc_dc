package org.cw.midc.service;


import org.cw.midc.ParamFilter;
import org.cw.midc.entity.Dict;
import org.cw.midc.entity.pojo.JSTree;

import java.util.List;

public interface DictService{

	void add(Dict dict);

	List<Dict> getList(ParamFilter queryFilter);

	void update(Dict dict);

	List<JSTree> getTree();

	List<Dict> getListByParentId(String parentId);

	List<Dict> getCatagory();

	void delete(List<String> id);

	Dict getById(String id);

}
