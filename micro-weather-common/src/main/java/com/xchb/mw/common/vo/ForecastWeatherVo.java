package com.xchb.mw.common.vo;

import lombok.Data;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description 未来天气
 */
@Data
public class ForecastWeatherVo {

    private String date;

    private String high;

    private String fengli;

    private String low;

    private String fengxiang;

    private String type;
}
