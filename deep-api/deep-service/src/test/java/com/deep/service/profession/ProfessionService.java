package com.deep.service.profession;

import com.deep.repository.profession.dto.ProfessionCategoryDto;
import com.deep.repository.profession.mapper.ProfessionCategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yangliuhua on 2017-6-21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration
@ContextConfiguration(locations = {"classpath*:application-context-repository.xml"})
public class ProfessionService {

    @Resource
    private ProfessionCategoryMapper professionCategoryMapper;

    @Test
    public void getAllProfession() {
        List<ProfessionCategoryDto> allProfession = professionCategoryMapper.getAllProfession();
        System.out.println(allProfession);
    }
}
