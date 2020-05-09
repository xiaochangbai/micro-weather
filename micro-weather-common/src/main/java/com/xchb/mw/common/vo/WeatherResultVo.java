package com.xchb.mw.common.vo;

import com.xchb.mw.common.enums.ResultEnum;
import lombok.Data;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */
@Data
public class WeatherResultVo {

    //状态码
    private Integer status;

    //状态描述
    private String desc;

    //天气数据，包括今天的天气和未来的天气
    private WeatherVo data;

    public WeatherResultVo(){}

    public WeatherResultVo(Integer status,String desc){
        this.status = status;
        this.desc = desc;
    }


    public static WeatherResultVo fail(){
        return new WeatherResultVo(ResultEnum.FALI.getCode(),ResultEnum.FALI.getMsg());
    }

    public static WeatherResultVo failMessage(String msg){
        return new WeatherResultVo(ResultEnum.FALI.getCode(),msg);
    }
}
