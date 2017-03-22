package org.cw.midc.config;

import org.apache.catalina.filters.RequestDumperFilter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan("org.cw.midc.filter")
public class WebConfig {
	@Bean
    RequestDumperFilter requestDumperFilter() {
        return new RequestDumperFilter();
    }
}
