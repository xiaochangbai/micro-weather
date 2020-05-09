package com.xchb.mw.collection.schedule;


import com.xchb.mw.common.dto.SimpleCity;
import com.xchb.mw.common.dto.SimpleCitys;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.xchb.mw.common.util.AppConst;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */
@Component
public class WeatherInfoSchedule {


    private final static Logger log = LoggerFactory.getLogger(WeatherInfoSchedule.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    /**
     * 每隔一小时获取最新天气信息，存redis
     * @throws IOException
     */
    //@Scheduled(cron = "0 0 0/1 * * ?") 每隔一小时进行一次数据采集
    @Scheduled(cron = "0 0/1 * * * ?")  //测试：每隔一分钟进行一次采集
    public void pullWeatherInfoToCache() throws IOException {
        long start = System.currentTimeMillis();
        //TODO 从城市服务中调取城市数据
        List<SimpleCity> data = new ArrayList<>(5);
        data.add(new SimpleCity("深圳","101280601"));
        data.add(new SimpleCity("澄海","101280503"));
        for(SimpleCity simpleCity:data){
            //根据id存
            String key = AppConst.WEATHER_URL+"?citykey="+simpleCity.getId();
            this.sycnSave(key);
        }
        long end = System.currentTimeMillis();
        log.info("信息保存完毕，共{}个城市信息,耗时{}/s",data.size(),(end-start)/1000);
    }


    /**
     * 异步保存信息进入redis
     * @param key
     */
    private void sycnSave(String key){
        try {
            log.info("[定时存redis],url={}",key);
            String result = null;
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            HttpClient httpClient = HttpClients.createDefault();
            HttpResponse execute = httpClient.execute(new HttpGet(key));
            HttpEntity entity = execute.getEntity();
            result = EntityUtils.toString(entity,"utf-8");
            //将结果存入redis
            operations.set(key,result, AppConst.OUTTIME_SECONDS, TimeUnit.SECONDS);
        }catch (Exception e){
            log.error("存入redis失败，key={},错误信息{}",key,e);
        }
    }


}
