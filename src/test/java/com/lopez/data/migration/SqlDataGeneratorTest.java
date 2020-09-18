package com.lopez.data.migration;

import com.lopez.data.migration.mapper.JyBondBaseInfoMapper;
import com.lopez.data.migration.mapper.JyBondCashFlowMapper;
import com.lopez.data.migration.mapper.JyBondCreditGradingMapper;
import com.lopez.data.migration.mapper.JyBondRelatedInstitutionsMapper;
import com.lopez.data.migration.mapper.JyBondSubjectRatingMapper;
import com.lopez.data.migration.model.JyBondBaseInfo;
import com.lopez.data.migration.model.JyBondCashFlow;
import com.lopez.data.migration.model.JyBondCreditGrading;
import com.lopez.data.migration.model.JyBondRelatedInstitutions;
import com.lopez.data.migration.model.JyBondSubjectRating;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlDataGeneratorTest {
    @Autowired
    private JyBondBaseInfoMapper bondBaseInfoMapper;

    @Autowired
    private JyBondCashFlowMapper bondCashFlowMapper;

    @Autowired
    private JyBondCreditGradingMapper bondCreditGradingMapper;

    @Autowired
    private JyBondSubjectRatingMapper bondSubjectRatingMapper;

    @Autowired
    private JyBondRelatedInstitutionsMapper bondRelatedInstitutionsMapper;

    @Test
    public void createBondBase() {
        List<JyBondBaseInfo> bondBaseInfos = bondBaseInfoMapper.selectList(null);
        List<String> sql_list = new ArrayList<>();
        for (JyBondBaseInfo bondBaseInfo : bondBaseInfos) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO jy_bond_base_info(" +
                    "bond_code, bond_market, main_code, inner_code, " +
                    "issuer, bond_full_name, bond_short_name, bond_type, " +
                    "value_date, end_date, issue_method, op_maturity, " +
                    "maturity, issue_ref_ytm, rate_if_float, float_base, " +
                    "base_rate, base_rate_type_name, issue_size, pay_interest, " +
                    "compound_method, listed_date, redemption_date, trustee, " +
                    "coupon_rate, bond_balance, bond_left_period, par_value, " +
                    "act_pay_date, interest_rate_period, redemption_reg_date, " +
                    "payment_date, payment_expire_date, company_code) VALUES (");
            stringBuilder.append(convertString(bondBaseInfo.getBondCode()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getBondMarket()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getMainCode()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getInnerCode()));
            stringBuilder.append(",");

            stringBuilder.append(convertString(bondBaseInfo.getIssuer()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getBondFullName()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getBondShortName()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getBondType()));
            stringBuilder.append(",");

            stringBuilder.append(convertString(bondBaseInfo.getValueDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getEndDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getIssueMethod()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getOpMaturity()));
            stringBuilder.append(",");

            stringBuilder.append(convertBigDecimal(bondBaseInfo.getMaturity()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondBaseInfo.getIssueRefYtm()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getRateIfFloat()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getFloatBase()));
            stringBuilder.append(",");

            stringBuilder.append(convertBigDecimal(bondBaseInfo.getBaseRate()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getBaseRateTypeName()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondBaseInfo.getIssueSize()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getPayInterest()));
            stringBuilder.append(",");

            stringBuilder.append(convertInteger(bondBaseInfo.getCompoundMethod()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getListedDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getRedemptionDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getTrustee()));
            stringBuilder.append(",");

            stringBuilder.append(convertBigDecimal(bondBaseInfo.getCouponRate()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondBaseInfo.getBondBalance()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondBaseInfo.getBondLeftPeriod()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondBaseInfo.getParValue()));
            stringBuilder.append(",");

            stringBuilder.append(convertString(bondBaseInfo.getActPayDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getInterestRatePeriod()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getRedemptionRegDate()));
            stringBuilder.append(",");

            stringBuilder.append(convertString(bondBaseInfo.getPaymentDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondBaseInfo.getPaymentExpireDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondBaseInfo.getCompanyCode()));
            stringBuilder.append(");");

            sql_list.add(stringBuilder.toString());
        }

        output(sql_list, createFile("BondBase.sql"));
    }

    @Test
    public void createBondCashFlow() {
        List<JyBondCashFlow> bondCashFlows = bondCashFlowMapper.selectList(null);
        List<String> sql_list = new ArrayList<>();
        for (JyBondCashFlow bondCashFlow : bondCashFlows) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO jy_bond_cash_flow(" +
                    "bond_code, bond_market, pay_interest_type, payment_date, payment_per, " +
                    "payment_amount, interest_per, pay_interest_amount, value_begin_date, " +
                    "value_end_date, TotalSize) VALUES (");
            stringBuilder.append(convertString(bondCashFlow.getBondCode()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondCashFlow.getBondMarket()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondCashFlow.getPayInterestType()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondCashFlow.getPaymentDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondCashFlow.getPaymentPer()));
            stringBuilder.append(",");

            stringBuilder.append(convertBigDecimal(bondCashFlow.getPaymentAmount()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondCashFlow.getInterestPer()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondCashFlow.getPayInterestAmount()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondCashFlow.getValueBeginDate()));
            stringBuilder.append(",");

            stringBuilder.append(convertString(bondCashFlow.getValueEndDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertBigDecimal(bondCashFlow.getTotalSize()));
            stringBuilder.append(");");

            sql_list.add(stringBuilder.toString());
        }

        output(sql_list, createFile("BondCashFlow.sql"));
    }

    @Test
    public void createBondCreditGrading() {
        List<JyBondCreditGrading> bondCreditGradings = bondCreditGradingMapper.selectList(null);
        List<String> sql_list = new ArrayList<>();
        for (JyBondCreditGrading bondCreditGrading : bondCreditGradings) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO jy_bond_credit_grading(" +
                    "main_code, publ_date, rating_code, rating_desc, rating_anticipate, rating_agency, " +
                    "rating_type, rating_method, rating_date) VALUES (");
            stringBuilder.append(convertInteger(bondCreditGrading.getMainCode()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondCreditGrading.getPublDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondCreditGrading.getRatingCode()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondCreditGrading.getRatingDesc()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondCreditGrading.getRatingAnticipate()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondCreditGrading.getRatingAgency()));
            stringBuilder.append(",");

            stringBuilder.append(convertInteger(bondCreditGrading.getRatingType()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondCreditGrading.getRatingMethod()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondCreditGrading.getRatingDate()));
            stringBuilder.append(");");

            sql_list.add(stringBuilder.toString());
        }

        output(sql_list, createFile("BondCreditGrading.sql"));
    }

    @Test
    public void createBondSubjectRating() {
        List<JyBondSubjectRating> bondSubjectRatings = bondSubjectRatingMapper.selectList(null);
        List<String> sql_list = new ArrayList<>();
        for (JyBondSubjectRating bondSubjectRating : bondSubjectRatings) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO jy_bond_subject_rating(" +
                    "company_code, company_name, publ_date, rating_code, rating_desc, " +
                    "rating_anticipate, rating_agency, rating_type, rating_method, " +
                    "rating_date) VALUES (");
            stringBuilder.append(convertInteger(bondSubjectRating.getCompanyCode()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondSubjectRating.getCompanyName()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondSubjectRating.getPublDate()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondSubjectRating.getRatingCode()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondSubjectRating.getRatingDesc()));
            stringBuilder.append(",");

            stringBuilder.append(convertInteger(bondSubjectRating.getRatingAnticipate()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondSubjectRating.getRatingAgency()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondSubjectRating.getRatingType()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondSubjectRating.getRatingMethod()));
            stringBuilder.append(",");

            stringBuilder.append(convertString(bondSubjectRating.getRatingDate()));
            stringBuilder.append(");");

            sql_list.add(stringBuilder.toString());
        }

        output(sql_list, createFile("BondSubjectRating.sql"));
    }

    @Test
    public void createBondRelatedInstitutions() {
        List<JyBondRelatedInstitutions> bondRelatedInstitutions = bondRelatedInstitutionsMapper.selectList(null);
        List<String> sql_list = new ArrayList<>();
        for (JyBondRelatedInstitutions bondRelatedInstitution : bondRelatedInstitutions) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("INSERT INTO jy_bond_related_institutions(" +
                    "main_code, agent_type, full_name, abbr_chi_name, legal_person_repr" +
                    ") VALUES (");
            stringBuilder.append(convertInteger(bondRelatedInstitution.getMainCode()));
            stringBuilder.append(",");
            stringBuilder.append(convertInteger(bondRelatedInstitution.getAgentType()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondRelatedInstitution.getFullName()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondRelatedInstitution.getAbbrChiName()));
            stringBuilder.append(",");
            stringBuilder.append(convertString(bondRelatedInstitution.getLegalPersonRepr()));
            stringBuilder.append(");");

            sql_list.add(stringBuilder.toString());
        }

        output(sql_list, createFile("BondRelatedInstitutions.sql"));
    }

    private File createFile(String fileName) {
        File file = new File("C:\\Users\\hugr\\Desktop\\", fileName);
        try {
            file.createNewFile();
        } catch (Exception ex) {
            return null;
        }
        return file;
    }

    private void output(List<String> sql_list, File file) {
        if (null == file)
            return;

        try (FileWriter writer = new FileWriter(file, true)) {
            for (String sql : sql_list) {
                writer.write(sql + "\r\n");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String convertString(String origin) {
        if (StringUtils.isEmpty(origin)) {
            return "' '";
        } else {
            return "'" + origin + "'";
        }
    }

    private Integer convertInteger(Integer origin) {
        if (origin == null) {
            return 0;
        } else {
            return origin;
        }
    }

    private BigDecimal convertBigDecimal(BigDecimal origin) {
        if (origin == null) {
            return new BigDecimal(0);
        } else {
            return origin;
        }
    }
}
