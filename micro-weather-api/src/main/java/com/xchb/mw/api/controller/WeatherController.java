package com.xchb.mw.api.controller;

import com.xchb.mw.api.service.WeatherService;
import com.xchb.mw.common.vo.WeatherResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @RequestMapping("/byname/{cityName}")
    public WeatherResultVo findByCityName(@PathVariable("cityName") String cityName) throws IOException {
        return weatherService.selectByCityName(cityName);
    }


    @RequestMapping("/byid/{cityId}")
    public WeatherResultVo findByCityId(@PathVariable("cityId") String cityId) throws IOException {
        return weatherService.selectByCityId(cityId);
    }

}
