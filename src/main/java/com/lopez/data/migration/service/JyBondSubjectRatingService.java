package com.lopez.data.migration.service;

import com.lopez.data.migration.model.JyBondSubjectRating;

import java.util.List;

public interface JyBondSubjectRatingService {
    /**
     * 新增债券主体评级信息
     *
     * @param bondSubjectRatingVO 债券主体评级信息
     */
    void addJyBondSubjectRating(JyBondSubjectRating bondSubjectRatingVO);

    /**
     * 新增债券主体评级信息
     *
     * @param bondSubjectRatingVOs 债券主体评级信息
     * @param batchSize            多少条提交一次
     */
    void addJyBondSubjectRatingBatch(List<JyBondSubjectRating> bondSubjectRatingVOs, Integer batchSize);

    /**
     * 查询债券主体评级信息列表
     *
     * @param bondSubjectRatingVO 债券主体评级信息
     * @return 债券主体评级信息列表
     */
    List<JyBondSubjectRating> listJyBondSubjectRating(JyBondSubjectRating bondSubjectRatingVO);
}
