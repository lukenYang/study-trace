package com.deep.repository.profession.mapper;

import com.deep.repository.profession.dto.ProfessionDto;
import com.deep.repository.profession.entity.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);

    List<ProfessionDto> getProfessionByCategoryId(Integer categoryId);
}