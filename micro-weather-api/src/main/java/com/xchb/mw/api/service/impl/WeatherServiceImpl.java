package com.xchb.mw.api.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xchb.mw.api.service.WeatherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import com.xchb.mw.common.util.AppConst;
import com.xchb.mw.common.vo.WeatherResultVo;

import java.io.IOException;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private final  static Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);


    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 根据城市名称获取天气信息
     * @param cityName
     * @return
     * @throws IOException
     */
    @Override
    public WeatherResultVo selectByCityName(String cityName) throws IOException {
        return this.onloadData(AppConst.WEATHER_URL+"?city="+cityName);
    }

    /**
     * 根据城市id获取天气信息
     * @param cityId
     * @return
     * @throws IOException
     */
    @Override
    public WeatherResultVo selectByCityId(String cityId) throws IOException {
        return this.onloadData(AppConst.WEATHER_URL+"?citykey="+cityId);
    }



    /**
     * 根据key从缓存中获取天气对象
     * @param url
     * @return
     * @throws IOException
     */
    private WeatherResultVo onloadData(String url) throws IOException {
        String result = null;
        //尝试从redis中中获取数据
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(url)){
            log.info("缓存访问命中,url={}",url);
            result = operations.get(url);
            System.out.println(result);
        }else{
            return WeatherResultVo.failMessage("数据不存在");
        }

        //将结果转成Vo返回
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResultVo weatherResultVo = objectMapper.readValue(result, WeatherResultVo.class);
        return weatherResultVo;
    }
}
