package com.xchb.mw.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/5
 * @description Good Good Study,Day Day Up.
 */
@Controller
public class WeatherController {


    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "cityName",required = false,defaultValue = "长沙") String cityName) throws IOException {
        Model model = new ExtendedModelMap();
        model.addAttribute("title","Tiany的个人天气系统");
        model.addAttribute("cityName",cityName);

        //TODO 从城市服务中获取城市列表
        model.addAttribute("citys",null);

        //TODO 调用天气服务获取，天气信息
        model.addAttribute("weathers",null);
        ModelAndView modelAndView = new ModelAndView("/pages/weather.html","wea",model);
        return modelAndView;
    }
}
