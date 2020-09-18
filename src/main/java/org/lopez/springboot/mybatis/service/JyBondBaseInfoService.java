package org.lopez.springboot.mybatis.service;

import org.lopez.springboot.mybatis.model.JyBondBaseInfo;

import java.util.List;

public interface JyBondBaseInfoService {
    /**
     * 新增债券基础信息
     *
     * @param bondBaseInfoVO 债券基础信息
     */
    void addJyBondBaseInfo(JyBondBaseInfo bondBaseInfoVO);

    /**
     * 批量新增债券基础信息
     *
     * @param bondBaseInfoVOs 债券基础信息
     * @param batchSize       多少条提交一次
     */
    void addJyBondBaseInfoBatch(List<JyBondBaseInfo> bondBaseInfoVOs, Integer batchSize);

    /**
     * 查询债券基础信息
     *
     * @param bondBaseInfoVO 债券基础信息
     * @return 债券基础信息列表
     */
    List<JyBondBaseInfo> listJyBondBaseInfo(JyBondBaseInfo bondBaseInfoVO);
}
