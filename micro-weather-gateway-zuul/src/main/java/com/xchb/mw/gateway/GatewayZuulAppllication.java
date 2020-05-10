package com.xchb.mw.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/10
 * @description Good Good Study,Day Day Up.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayZuulAppllication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayZuulAppllication.class,args);
    }
}
