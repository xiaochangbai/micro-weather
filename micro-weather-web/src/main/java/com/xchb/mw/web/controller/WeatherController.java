package com.xchb.mw.web.controller;

import com.xchb.mw.web.service.WebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/5
 * @description Good Good Study,Day Day Up.
 */
@Controller
public class WeatherController {

    @Resource
    private WebClient webClient;

    @Value("${author}")
    private String author;

    @RequestMapping("/index")
    public ModelAndView index(@RequestParam(value = "cityId",required = false,defaultValue = "101250101") String cityId) throws IOException {
        Model model = new ExtendedModelMap();
        model.addAttribute("title","Tiany的个人天气系统");
        model.addAttribute("cityId",cityId);
        System.out.println("作者："+author);
        //从城市服务中获取城市列表
        model.addAttribute("citys",webClient.cityList().getData());

        //调用天气服务获取，天气信息
        model.addAttribute("weathers",webClient.findByCityId(cityId));
        ModelAndView modelAndView = new ModelAndView("/pages/weather.html","wea",model);
        return modelAndView;
    }
}
