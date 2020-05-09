package com.xchb.mw.api.controller;

import com.xchb.mw.common.vo.WeatherResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/9
 * @description 全局异常处理器
 */
@ControllerAdvice
public class ExceptionHandlerController {

    private static Logger log = LoggerFactory.getLogger(ExceptionHandlerController.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public WeatherResultVo exception(Exception e){
        log.error("服务器全局异常，{}",e);
        return WeatherResultVo.failMessage("服务器异常");
    }
}
