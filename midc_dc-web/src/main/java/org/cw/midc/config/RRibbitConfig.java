package org.cw.midc.config;

import java.util.ArrayList;
import java.util.List;

import org.rribbit.RequestResponseBus;
import org.rribbit.creation.SpringBeanClassBasedListenerObjectCreator;
import org.rribbit.util.RRiBbitUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RRibbitConfig {
	
	@Bean
	public SpringBeanClassBasedListenerObjectCreator creator()
	{
		SpringBeanClassBasedListenerObjectCreator creator = new SpringBeanClassBasedListenerObjectCreator();
		List<String> classNames = new ArrayList<String>();
		classNames.add("org.cw.midc.service.DicomFileService");
		classNames.add("org.cw.midc.service.LoadDicomFileService");
		creator.setClassNames(classNames);
		return creator;
	}
	
	@Bean
	public RequestResponseBus rribbit()
	{
		RequestResponseBus rrb = RRiBbitUtil.createRequestResponseBusForLocalUse(creator(), true);
		return rrb;
	}
}
