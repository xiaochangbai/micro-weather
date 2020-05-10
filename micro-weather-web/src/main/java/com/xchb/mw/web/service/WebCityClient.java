package com.xchb.mw.web.service;

import com.xchb.mw.common.dto.SimpleCitys;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/10
 * @description Good Good Study,Day Day Up.
 */
@FeignClient("micro-weather-city-server")
public interface WebCityClient {

    @GetMapping("/city/list")
    SimpleCitys list();
}
