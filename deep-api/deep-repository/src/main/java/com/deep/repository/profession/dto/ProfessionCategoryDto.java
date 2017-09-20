package com.deep.repository.profession.dto;

import com.deep.repository.common.BaseDto;

import java.util.List;

/**
 * Created by yangliuhua on 2017-6-21.
 */
public class ProfessionCategoryDto extends BaseDto {

    private Integer id;

    private String name;

    private Integer orders;
    
    List<ProfessionDto> professionList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public List<ProfessionDto> getProfessionList() {
        return professionList;
    }

    public void setProfessionList(List<ProfessionDto> professionList) {
        this.professionList = professionList;
    }
}
