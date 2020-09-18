package com.lopez.data.migration.service;

import com.lopez.data.migration.model.JyBondCashFlow;

import java.util.List;

public interface JyBondCashFlowService {
    /**
     * 新增债券付息信息
     *
     * @param bondCashFlowVO 债券付息信息
     */
    void addJyBondCashFlow(JyBondCashFlow bondCashFlowVO);

    /**
     * 批量新增债券付息信息
     *
     * @param bondCashFlowVOs 债券付息信息
     * @param batchSize       多少条提交一次
     */
    void addJyBondCashFlowBatch(List<JyBondCashFlow> bondCashFlowVOs, Integer batchSize);

    /**
     * 查询债券付息信息
     *
     * @param bondCashFlowVO 债券付息信息
     * @return 债券付息信息列表
     */
    List<JyBondCashFlow> listJyBondCashFlow(JyBondCashFlow bondCashFlowVO);
}
