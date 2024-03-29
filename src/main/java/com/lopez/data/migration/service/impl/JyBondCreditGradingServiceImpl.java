package com.lopez.data.migration.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lopez.data.migration.mapper.JyBondCreditGradingMapper;
import com.lopez.data.migration.model.JyBondCreditGrading;
import com.lopez.data.migration.service.JyBondCreditGradingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JyBondCreditGradingServiceImpl extends ServiceImpl<JyBondCreditGradingMapper, JyBondCreditGrading> implements JyBondCreditGradingService {

    @DS("oracle")
    @Override
    public void addJyBondCreditGrading(JyBondCreditGrading bondCreditGradingVO) {
        baseMapper.insert(bondCreditGradingVO);
    }

    @DS("oracle")
    @Override
    public void addJyBondCreditGradingBatch(List<JyBondCreditGrading> bondCreditGradingVOs, Integer batchSize) {
        saveBatch(bondCreditGradingVOs, batchSize);
    }

    @DS("mysql")
    @Override
    public List<JyBondCreditGrading> listJyBondCreditGrading(JyBondCreditGrading bondCreditGradingVO) {
        return baseMapper.selectList(new QueryWrapper<>(bondCreditGradingVO));
    }
}
