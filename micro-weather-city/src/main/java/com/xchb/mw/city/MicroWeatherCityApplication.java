package com.xchb.mw.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/9
 * @description Good Good Study,Day Day Up.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MicroWeatherCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherCityApplication.class,args);
    }

}
