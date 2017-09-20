package com.deep.service.test.impl;

import com.deep.repository.profession.entity.Profession;
import com.deep.repository.profession.entity.ProfessionCategory;
import com.deep.repository.profession.mapper.ProfessionCategoryMapper;
import com.deep.repository.profession.mapper.ProfessionMapper;
import com.deep.service.test.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yangliuhua on 2017-6-1.
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private ProfessionMapper professionMapper;
    @Resource
    private ProfessionCategoryMapper professionCategoryMapper;

    @Override
    public String getString() {
        Profession profession = new Profession();
        profession.setName("java");
        profession.setType(1);
        profession.setCategoryId(1);
        profession.setKeywords("web");
        profession.setStatus(1);
        profession.setOrders(1);
        profession.setCreateTime(454L);
        professionMapper.insertSelective(profession);

        ProfessionCategory category = new ProfessionCategory();
        category.setCreateTime(465L);
        category.setStatus(1);
        category.setKeywords("fdasfda");
        category.setName("c++");
        category.setOrders(1);
        professionCategoryMapper.insertSelective(category);
        return "123456798";
    }

    @Override
    public void addEntity() {
        Profession profession = new Profession();
        profession.setName("java");
        profession.setType(1);
        profession.setCategoryId(1);
        profession.setKeywords("web");
        profession.setStatus(1);
        profession.setOrders(1);
        profession.setCreateTime(454L);
        professionMapper.insertSelective(profession);

        ProfessionCategory category = new ProfessionCategory();
        category.setCreateTime(465L);
        category.setStatus(1);
        category.setKeywords("fdasfda");
        category.setName("c++");
        category.setOrders(1);
        professionCategoryMapper.insertSelective(category);
    }
}
