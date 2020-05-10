package com.xchb.mw.web.service;

import com.xchb.mw.common.dto.SimpleCity;
import com.xchb.mw.common.dto.SimpleCitys;
import com.xchb.mw.common.vo.WeatherResultVo;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/10
 * @description WebClient 接口异常后熔断处理类
 */
@Component
public class WebClientFallback implements WebClient {
    @Override
    public WeatherResultVo findByCityId(String cityId) {
        System.out.println("天气服务熔断");
        return new WeatherResultVo();
    }

    @Override
    public SimpleCitys cityList() {
        System.out.println("城市服务熔断");
        SimpleCitys result = new SimpleCitys();
        List<SimpleCity> simpleCities = new ArrayList<>();
        SimpleCity city1 = new SimpleCity("长沙","101250101");
        simpleCities.add(city1);
        SimpleCity city2 = new SimpleCity("杭州","101210101");
        simpleCities.add(city2);
        SimpleCity city3 = new SimpleCity("深圳","101280601");
        simpleCities.add(city3);
        result.setData(simpleCities);
        return result;
    }
}
