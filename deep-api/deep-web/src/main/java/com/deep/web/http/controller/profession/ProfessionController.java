package com.deep.web.http.controller.profession;

import com.deep.service.profession.IProfessionService;
import com.deep.web.http.controller.BaseController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yangliuhua on 2017-6-21.
 */
@RestController
@RequestMapping(value = "/api/pf")
public class ProfessionController extends BaseController {

    @Resource
    private IProfessionService professionService;

    @RequestMapping(value = "/pfList", name = "获取职业列表")
    public Object getAllProfession() {
        return success(professionService.getAllProfession());
    }
}
