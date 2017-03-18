package org.cw.midc.service.factory;

import org.dozer.DozerBeanMapper;

public class DozerBeanMapperFactory {
	
	private static DozerBeanMapper mapper = null;

    public static DozerBeanMapper getMapper(){   
        if(mapper==null){   
        	mapper = new DozerBeanMapper();      
        }   
        return mapper;   
    } 
}
