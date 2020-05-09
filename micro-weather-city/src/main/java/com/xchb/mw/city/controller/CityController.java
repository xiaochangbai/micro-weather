package com.xchb.mw.city.controller;

import com.xchb.mw.city.service.CityDataService;
import com.xchb.mw.common.dto.SimpleCitys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/9
 * @description Good Good Study,Day Day Up.
 */
@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @RequestMapping("/list")
    public SimpleCitys list() throws IOException {
        return cityDataService.parse();
    }
}
