package com.deep.service.profession;

import com.deep.repository.profession.dto.ProfessionCategoryDto;

import java.util.List;

/**
 * Created by yangliuhua on 2017-6-21.
 */
public interface IProfessionService {

    List<ProfessionCategoryDto> getAllProfession();
}
