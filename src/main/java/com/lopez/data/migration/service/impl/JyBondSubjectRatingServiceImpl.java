package com.lopez.data.migration.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lopez.data.migration.mapper.JyBondSubjectRatingMapper;
import com.lopez.data.migration.model.JyBondSubjectRating;
import com.lopez.data.migration.service.JyBondSubjectRatingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JyBondSubjectRatingServiceImpl extends ServiceImpl<JyBondSubjectRatingMapper, JyBondSubjectRating> implements JyBondSubjectRatingService {

    @DS("oracle")
    @Override
    public void addJyBondSubjectRating(JyBondSubjectRating bondSubjectRatingVO) {
        baseMapper.insert(bondSubjectRatingVO);
    }

    @DS("oracle")
    @Override
    public void addJyBondSubjectRatingBatch(List<JyBondSubjectRating> bondSubjectRatingVOs, Integer batchSize) {
        saveBatch(bondSubjectRatingVOs, batchSize);
    }

    @DS("mysql")
    @Override
    public List<JyBondSubjectRating> listJyBondSubjectRating(JyBondSubjectRating bondSubjectRatingVO) {
        return baseMapper.selectList(new QueryWrapper<>(bondSubjectRatingVO));
    }
}
