package com.xchb.mw.api.service;

import com.xchb.mw.common.vo.WeatherResultVo;

import java.io.IOException;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */
public interface WeatherService {

    /**
     * 根据城市名称获取天气信息
     * @param cityName
     * @return
     * @throws IOException
     */
    WeatherResultVo selectByCityName(String cityName) throws IOException;


    /**
     * 根据城市id获取天气信息
     * @param cityId
     * @return
     * @throws IOException
     */
    WeatherResultVo selectByCityId(String cityId) throws IOException;
}
