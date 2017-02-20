package org.cw.midc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
/**
 * Spring boot 启动
 * @author cloud
 *
 */

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class MidcApplication {

    public static void main( String[] args )
    {
        SpringApplication.run(MidcApplication.class, args);
    }
}
