package org.lopez.springboot.mybatis.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.lopez.springboot.mybatis.mapper.JyBondBaseInfoMapper;
import org.lopez.springboot.mybatis.model.JyBondBaseInfo;
import org.lopez.springboot.mybatis.service.JyBondBaseInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JyBondBaseInfoServiceImpl extends ServiceImpl<JyBondBaseInfoMapper, JyBondBaseInfo> implements JyBondBaseInfoService {

    @DS("oracle")
    @Override
    public void addJyBondBaseInfo(JyBondBaseInfo bondBaseInfoVO) {
        baseMapper.insert(bondBaseInfoVO);
    }

    @DS("oracle")
    @Override
    public void addJyBondBaseInfoBatch(List<JyBondBaseInfo> bondBaseInfoVOs, Integer batchSize) {
        saveBatch(bondBaseInfoVOs, batchSize);
    }

    @DS("mysql")
    @Override
    public List<JyBondBaseInfo> listJyBondBaseInfo(JyBondBaseInfo bondBaseInfoVO) {
        return baseMapper.selectList(new QueryWrapper<>(bondBaseInfoVO));
    }
}
