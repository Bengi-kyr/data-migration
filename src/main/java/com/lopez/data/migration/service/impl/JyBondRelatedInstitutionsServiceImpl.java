package com.lopez.data.migration.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lopez.data.migration.mapper.JyBondRelatedInstitutionsMapper;
import com.lopez.data.migration.model.JyBondRelatedInstitutions;
import com.lopez.data.migration.service.JyBondRelatedInstitutionsService;
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
