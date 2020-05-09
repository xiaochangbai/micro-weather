package com.xchb.mw.city.service;



import com.xchb.mw.common.dto.SimpleCitys;

import java.io.IOException;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */

public interface CityDataService {

    /**
     * 城市提供服务
     * @return
     * @throws IOException
     */
    SimpleCitys parse() throws IOException;
}
