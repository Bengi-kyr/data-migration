package org.lopez.springboot.mybatis.service;

import org.lopez.springboot.mybatis.model.JyBondCreditGrading;

import java.util.List;

public interface JyBondCreditGradingService {
    /**
     * 新增债券评级信息
     *
     * @param bondCreditGradingVO 债券评级信息
     */
    void addJyBondCreditGrading(JyBondCreditGrading bondCreditGradingVO);

    /**
     * 批量新增债券评级信息
     *
     * @param bondCreditGradingVOs 债券评级信息
     * @param batchSize            多少条提交一次
     */
    void addJyBondCreditGradingBatch(List<JyBondCreditGrading> bondCreditGradingVOs, Integer batchSize);

    /**
     * 查询债券评级信息列表
     *
     * @param bondCreditGradingVO 债券评级信息
     * @return 债券评级信息列表
     */
    List<JyBondCreditGrading> listJyBondCreditGrading(JyBondCreditGrading bondCreditGradingVO);
}
