package com.deep.repository.profession.dto;

import com.deep.repository.common.BaseDto;

/**
 * Created by yangliuhua on 2017-6-21.
 */
public class ProfessionDto extends BaseDto {

    private Integer id;

    private String name;

    private Integer categoryId;

    private Integer orders;

    private Integer type;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

}
