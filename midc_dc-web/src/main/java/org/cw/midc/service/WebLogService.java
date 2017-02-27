package org.cw.midc.service;

import org.cw.midc.ParamFilter;
import org.cw.midc.entity.WebLog;

import java.util.List;

public interface WebLogService {

     void add(WebLog webLog);

    void delete(String[] webLogIds);

    void update(WebLog webLog);

    List<WebLog> getList(ParamFilter paramFilter);
}
