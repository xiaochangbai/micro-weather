package com.xchb.mw.collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/9
 * @description Good Good Study,Day Day Up.
 */
@SpringBootApplication
@EnableScheduling
public class MicroWeatherCollectionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroWeatherCollectionApplication.class,args);
    }

}
