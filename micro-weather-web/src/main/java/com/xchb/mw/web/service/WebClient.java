package com.xchb.mw.web.service;

import com.xchb.mw.common.dto.SimpleCitys;
import com.xchb.mw.common.vo.WeatherResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/10
 * @description Good Good Study,Day Day Up.
 */
@FeignClient(name = "micro-weather-gateway-zuul",fallback = WebClientFallback.class)
public interface WebClient {

    @RequestMapping("/weather/byid/{cityId}")
    WeatherResultVo findByCityId(@PathVariable("cityId") String cityId);

    @RequestMapping("/city/list")
    SimpleCitys cityList();
}
