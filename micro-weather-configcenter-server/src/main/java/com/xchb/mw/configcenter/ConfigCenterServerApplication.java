package com.xchb.mw.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/10
 * @description Good Good Study,Day Day Up.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigCenterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterServerApplication.class,args);
    }
}
