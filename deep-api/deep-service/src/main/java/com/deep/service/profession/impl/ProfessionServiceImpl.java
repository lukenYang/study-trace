package com.deep.service.profession.impl;

import com.deep.repository.profession.dto.ProfessionCategoryDto;
import com.deep.repository.profession.mapper.ProfessionCategoryMapper;
import com.deep.service.profession.IProfessionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangliuhua on 2017-6-21.
 */
@Service
public class ProfessionServiceImpl implements IProfessionService {

    @Resource
    private ProfessionCategoryMapper professionCategoryMapper;

    @Override
    public List<ProfessionCategoryDto> getAllProfession() {
        return professionCategoryMapper.getAllProfession();
    }
}
