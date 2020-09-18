package org.lopez.springboot.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lopez.springboot.mybatis.mapper.JyBondRelatedInstitutionsMapper;
import org.lopez.springboot.mybatis.model.JyBondRelatedInstitutions;
import org.lopez.springboot.mybatis.service.JyBondRelatedInstitutionsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JyBondRelatedInstitutionsServiceImpl extends ServiceImpl<JyBondRelatedInstitutionsMapper, JyBondRelatedInstitutions> implements JyBondRelatedInstitutionsService {

    @DS("oracle")
    @Override
    public void addJyBondRelatedInstitutions(JyBondRelatedInstitutions bondRelatedInstitutionsVO) {
        baseMapper.insert(bondRelatedInstitutionsVO);
    }

    @DS("oracle")
    @Override
    public void addJyBondRelatedInstitutionsBatch(List<JyBondRelatedInstitutions> bondRelatedInstitutionsVOs, Integer batchSize) {
        saveBatch(bondRelatedInstitutionsVOs, batchSize);
    }

    @DS("mysql")
    @Override
    public List<JyBondRelatedInstitutions> listJyBondRelatedInstitutions(JyBondRelatedInstitutions bondRelatedInstitutionsVO) {
        return baseMapper.selectList(new QueryWrapper<>(bondRelatedInstitutionsVO));
    }
}
