package com.lopez.data.migration.service;

import com.lopez.data.migration.model.JyBondRelatedInstitutions;

import java.util.List;

public interface JyBondRelatedInstitutionsService {
    /**
     * 新增债券相关机构信息
     *
     * @param bondRelatedInstitutionsVO 债券相关机构信息
     */
    void addJyBondRelatedInstitutions(JyBondRelatedInstitutions bondRelatedInstitutionsVO);

    /**
     * 批量新增债券相关机构信息
     *
     * @param bondRelatedInstitutionsVOs 债券相关机构信息
     * @param batchSize                  多少条提交一次
     */
    void addJyBondRelatedInstitutionsBatch(List<JyBondRelatedInstitutions> bondRelatedInstitutionsVOs, Integer batchSize);

    /**
     * 查询债券相关机构信息
     *
     * @param bondRelatedInstitutionsVO 债券相关机构信息
     * @return 债券相关机构信息列表
     */
    List<JyBondRelatedInstitutions> listJyBondRelatedInstitutions(JyBondRelatedInstitutions bondRelatedInstitutionsVO);
}
