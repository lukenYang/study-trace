package com.deep.service.catalog;

import com.deep.repository.catalog.dto.ContentCatalogDto;
import com.deep.service.catalog.vo.CatalogVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by yangliuhua on 2017-6-21.
 */
public interface ICatalogService {

    Map<String, Object> getPrimaryCatalogByProfessionId(Integer ProfessionId);

    List<ContentCatalogDto> getChildrenCatalogByParentId(Integer ParentId);

    int addCatalog(List<CatalogVo> catalogVoList);

    int updateCatalog(List<CatalogVo> catalogVoList);
}
