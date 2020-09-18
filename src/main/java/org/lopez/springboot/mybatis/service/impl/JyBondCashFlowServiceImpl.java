package org.lopez.springboot.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lopez.springboot.mybatis.mapper.JyBondCashFlowMapper;
import org.lopez.springboot.mybatis.model.JyBondCashFlow;
import org.lopez.springboot.mybatis.service.JyBondCashFlowService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JyBondCashFlowServiceImpl extends ServiceImpl<JyBondCashFlowMapper, JyBondCashFlow> implements JyBondCashFlowService {

    @DS("oracle")
    @Override
    public void addJyBondCashFlow(JyBondCashFlow bondCashFlowVO) {
        baseMapper.insert(bondCashFlowVO);
    }

    @DS("oracle")
    @Override
    public void addJyBondCashFlowBatch(List<JyBondCashFlow> bondCashFlowVOs, Integer batchSize) {
        saveBatch(bondCashFlowVOs, batchSize);
    }

    @DS("mysql")
    @Override
    public List<JyBondCashFlow> listJyBondCashFlow(JyBondCashFlow bondCashFlowVO) {
        return baseMapper.selectList(new QueryWrapper<>(bondCashFlowVO));
    }
}
