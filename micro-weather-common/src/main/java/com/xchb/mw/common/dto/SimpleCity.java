package com.xchb.mw.common.dto;

import lombok.Data;

/**
 * @author XDD
 * @project micro-weather
 * @date 2020/5/6
 * @description Good Good Study,Day Day Up.
 */
@Data
public class SimpleCity {

    private String name;

    private String id;

    public SimpleCity(){}

    public SimpleCity(String name,String id){
        this.name=name;
        this.id=id;
    }
}
