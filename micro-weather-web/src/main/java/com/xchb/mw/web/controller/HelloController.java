package com.xchb.mw.web.controller;

import com.xchb.mw.common.dto.SimpleCitys;

import com.xchb.mw.web.service.WebCityClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/10
 * @description Good Good Study,Day Day Up.
 */
@RestController
public class HelloController {

    @Autowired
    private WebCityClient webCityClient;

    @RequestMapping("/citys")
    public SimpleCitys citys(){
        return webCityClient.list();
    }
}
