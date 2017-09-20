package com.deep.web.http.controller.catalog;

import com.deep.service.catalog.ICatalogService;
import com.deep.service.catalog.vo.CatalogVo;
import com.deep.web.http.controller.BaseController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangliuhua on 2017-6-21.
 */
@RestController
@RequestMapping(value = "/api/cl")
public class CatalogController extends BaseController {

    @Resource
    private ICatalogService catalogService;

    @RequestMapping(value = "/add")
    public Object addCatalog(@RequestBody List<CatalogVo> catalogVoList) {
        catalogService.addCatalog(catalogVoList);
        return success();
    }

    @RequestMapping(value = "/update")
    public Object updateCatalog(@RequestBody List<CatalogVo> catalogVoList) {
        catalogService.updateCatalog(catalogVoList);
        return success();
    }

    @RequestMapping(value = "/getPrimaryCatalog")
    public Object getPrimaryCatalog(Integer pid) {
        return success(catalogService.getPrimaryCatalogByProfessionId(pid));
    }

    @RequestMapping(value = "/getChildrenCatalog")
    public Object getChildrenCatalog(Integer parentId) {
        return success(catalogService.getChildrenCatalogByParentId(parentId));
    }
}
