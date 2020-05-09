package com.xchb.mw.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */

@Data
public class WeatherVo {

    //城市
    private String city;

    private String ganmao;

    private String wendu;

    private String aqi;

    //今天的天气
    private YesterdayWeatherVo yesterday;


    //预测未来的天气
    private List<ForecastWeatherVo> forecast;
}
