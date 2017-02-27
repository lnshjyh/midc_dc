package org.cw.midc.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan("org.cw.midc.filter")
public class WebConfig {
}
