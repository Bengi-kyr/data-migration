package com.lopez.data.migration;

import com.lopez.data.migration.service.JyBondBaseInfoService;
import com.lopez.data.migration.service.JyBondCreditGradingService;
import com.lopez.data.migration.service.JyBondRelatedInstitutionsService;
import com.lopez.data.migration.service.JyBondSubjectRatingService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.lopez.data.migration.model.JyBondBaseInfo;
import com.lopez.data.migration.model.JyBondCashFlow;
import com.lopez.data.migration.model.JyBondCreditGrading;
import com.lopez.data.migration.model.JyBondRelatedInstitutions;
import com.lopez.data.migration.model.JyBondSubjectRating;
import com.lopez.data.migration.service.JyBondCashFlowService;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.JVM)
public class BondDataMigrationTest {

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

    @Test
    public void JyBondBaseInfoSyncTest() {
        JyBondBaseInfo bondBaseInfoVO = new JyBondBaseInfo();
        List<JyBondBaseInfo> bondBaseInfoList = bondBaseInfoService.listJyBondBaseInfo(bondBaseInfoVO);
        Assert.notNull(bondBaseInfoList, "未查询到对应的债券基础信息");
        bondBaseInfoService.addJyBondBaseInfoBatch(bondBaseInfoList, 2000);
    }

    @Test
    public void JyBondCashFlowSyncTest() {
        JyBondCashFlow bondCashFlowVO = new JyBondCashFlow();
        List<JyBondCashFlow> bondCashFlowList = bondCashFlowService.listJyBondCashFlow(bondCashFlowVO);
        Assert.notNull(bondCashFlowList, "未查询到对应的债券付息信息");
        bondCashFlowService.addJyBondCashFlowBatch(bondCashFlowList, 2000);
    }

    @Test
    public void JyBondCreditGradingSyncTest() {
        JyBondCreditGrading bondCreditGradingVO = new JyBondCreditGrading();
        List<JyBondCreditGrading> bondCreditGradingList = bondCreditGradingService.listJyBondCreditGrading(bondCreditGradingVO);
        Assert.notNull(bondCreditGradingList, "未查询到对应的债券评级信息");
        bondCreditGradingService.addJyBondCreditGradingBatch(bondCreditGradingList, 2000);
    }

    @Test
    public void JyBondRelatedInstitutionsSyncTest() {
        JyBondRelatedInstitutions bondRelatedInstitutionsVO = new JyBondRelatedInstitutions();
        List<JyBondRelatedInstitutions> bondRelatedInstitutionsList = bondRelatedInstitutionsService.listJyBondRelatedInstitutions(bondRelatedInstitutionsVO);
        Assert.notNull(bondRelatedInstitutionsList, "未查询到对应的债券相关机构信息");
        bondRelatedInstitutionsService.addJyBondRelatedInstitutionsBatch(bondRelatedInstitutionsList, 2000);
    }

    @Test
    public void JyBondSubjectRatingSyncTest() {
        JyBondSubjectRating bondSubjectRatingVO = new JyBondSubjectRating();
        List<JyBondSubjectRating> bondSubjectRatingList = bondSubjectRatingService.listJyBondSubjectRating(bondSubjectRatingVO);
        Assert.notNull(bondSubjectRatingList, "未查询到对应的债券主体评级信息");
        bondSubjectRatingService.addJyBondSubjectRatingBatch(bondSubjectRatingList, 2000);
    }
}
