package com.xchb.mw.city.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xchb.mw.city.service.CityDataService;
import com.xchb.mw.common.dto.SimpleCitys;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public SimpleCitys parse() throws IOException {
        ClassPathResource resource = new ClassPathResource("chinacitylist.json");
        InputStream resourceAsStream = resource.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream,"utf-8"));
        String line = null;
        StringBuilder builder = new StringBuilder("");
        while ((line=bufferedReader.readLine())!=null){
            builder.append(line);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleCitys simpleCitys = objectMapper.readValue(builder.toString(), SimpleCitys.class);


        if(bufferedReader!=null){
            bufferedReader.close();
        }
        if(resourceAsStream!=null){
            resourceAsStream.close();
        }

        return simpleCitys;
    }
}
