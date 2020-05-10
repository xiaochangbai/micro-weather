package com.xchb.mw.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/10
 * @description Good Good Study,Day Day Up.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerAppllication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerAppllication.class,args);
    }
}
