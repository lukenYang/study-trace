package com.deep.service.catalog.vo;

import com.deep.service.common.BaseVo;

/**
 * Created by yangliuhua on 2017-6-21.
 */
public class CatalogVo extends BaseVo {

    private Integer id;
    private Integer parentId;
    private String title;
    private String stage;
    private Integer order;
    private Integer professionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getProfessionId() {
        return professionId;
    }

    public void setProfessionId(Integer professionId) {
        this.professionId = professionId;
    }
}
