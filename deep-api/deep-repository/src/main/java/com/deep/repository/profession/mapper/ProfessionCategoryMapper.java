package com.deep.repository.profession.mapper;

import com.deep.repository.profession.dto.ProfessionCategoryDto;
import com.deep.repository.profession.entity.ProfessionCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProfessionCategory record);

    int insertSelective(ProfessionCategory record);

    ProfessionCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProfessionCategory record);

    int updateByPrimaryKey(ProfessionCategory record);

    List<ProfessionCategoryDto> getAllProfession();
}