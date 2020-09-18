package com.lopez.data.migration.controller;

import com.lopez.data.migration.model.JyBondBaseInfo;
import com.lopez.data.migration.model.JyBondCashFlow;
import com.lopez.data.migration.model.JyBondCreditGrading;
import com.lopez.data.migration.model.JyBondRelatedInstitutions;
import com.lopez.data.migration.model.JyBondSubjectRating;
import com.lopez.data.migration.service.JyBondBaseInfoService;
import com.lopez.data.migration.service.JyBondCashFlowService;
import com.lopez.data.migration.service.JyBondCreditGradingService;
import com.lopez.data.migration.service.JyBondRelatedInstitutionsService;
import com.lopez.data.migration.service.JyBondSubjectRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/migration")
public class IndexController {

    @Autowired
    private JyBondBaseInfoService bondBaseInfoService;

    @Autowired
    private JyBondCashFlowService bondCashFlowService;

    @Autowired
    private JyBondCreditGradingService bondCreditGradingService;

    @Autowired
    private JyBondRelatedInstitutionsService bondRelatedInstitutionsService;

    @Autowired
    private JyBondSubjectRatingService bondSubjectRatingService;

    @RequestMapping("/home")
    public String index() {
        return "Hello Everybody.";
    }

    @RequestMapping("/all")
    public String migrationAll() {
        bondBaseInfoSync();
        bondCashFlowSync();
        bondCreditGradingSync();
        bondRelatedInstitutionsSync();
        bondSubjectRatingSync();
        return "Success";
    }

    @RequestMapping("/bondBaseInfo")
    public void bondBaseInfoSync() {
        JyBondBaseInfo bondBaseInfoVO = new JyBondBaseInfo();
        List<JyBondBaseInfo> bondBaseInfoList = bondBaseInfoService.listJyBondBaseInfo(bondBaseInfoVO);
        bondBaseInfoService.addJyBondBaseInfoBatch(bondBaseInfoList, 2000);
    }

    @RequestMapping("/bondCashFlow")
    public void bondCashFlowSync() {
        JyBondCashFlow bondCashFlowVO = new JyBondCashFlow();
        List<JyBondCashFlow> bondCashFlowList = bondCashFlowService.listJyBondCashFlow(bondCashFlowVO);
        bondCashFlowService.addJyBondCashFlowBatch(bondCashFlowList, 2000);
    }

    @RequestMapping("/bondCreditGrading")
    public void bondCreditGradingSync() {
        JyBondCreditGrading bondCreditGradingVO = new JyBondCreditGrading();
        List<JyBondCreditGrading> bondCreditGradingList = bondCreditGradingService.listJyBondCreditGrading(bondCreditGradingVO);
        bondCreditGradingService.addJyBondCreditGradingBatch(bondCreditGradingList, 2000);
    }

    @RequestMapping("/bondRelatedInstitutions")
    public void bondRelatedInstitutionsSync() {
        JyBondRelatedInstitutions bondRelatedInstitutionsVO = new JyBondRelatedInstitutions();
        List<JyBondRelatedInstitutions> bondRelatedInstitutionsList = bondRelatedInstitutionsService.listJyBondRelatedInstitutions(bondRelatedInstitutionsVO);
        bondRelatedInstitutionsService.addJyBondRelatedInstitutionsBatch(bondRelatedInstitutionsList, 2000);
    }

    @RequestMapping("/bondSubjectRating")
    public void bondSubjectRatingSync() {
        JyBondSubjectRating bondSubjectRatingVO = new JyBondSubjectRating();
        List<JyBondSubjectRating> bondSubjectRatingList = bondSubjectRatingService.listJyBondSubjectRating(bondSubjectRatingVO);
        bondSubjectRatingService.addJyBondSubjectRatingBatch(bondSubjectRatingList, 2000);
    }
}
