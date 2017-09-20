package com.deep.repository.catalog.mapper;

import com.deep.repository.catalog.dto.ContentCatalogDto;
import com.deep.repository.catalog.entity.ContentCatalog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentCatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContentCatalog record);

    int insertSelective(ContentCatalog record);

    ContentCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContentCatalog record);

    int updateByPrimaryKey(ContentCatalog record);

    List<ContentCatalogDto> selectPrimaryCatalogByProfessionId(@Param("professionId") Integer professionId);

    List<ContentCatalogDto> selectChildrenCatalogByParentId(@Param("parentId") Integer parentId);
}