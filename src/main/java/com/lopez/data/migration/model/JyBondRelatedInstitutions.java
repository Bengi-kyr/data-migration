package com.lopez.data.migration.model;

public class JyBondRelatedInstitutions {
    private Integer mainCode;

    private Integer agentType;

    private String fullName;

    private String abbrChiName;

    private String legalPersonRepr;

    public Integer getMainCode() {
        return mainCode;
    }

    public void setMainCode(Integer mainCode) {
        this.mainCode = mainCode;
    }

    public Integer getAgentType() {
        return agentType;
    }

    public void setAgentType(Integer agentType) {
        this.agentType = agentType;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAbbrChiName() {
        return abbrChiName;
    }

    public void setAbbrChiName(String abbrChiName) {
        this.abbrChiName = abbrChiName;
    }

    public String getLegalPersonRepr() {
        return legalPersonRepr;
    }

    public void setLegalPersonRepr(String legalPersonRepr) {
        this.legalPersonRepr = legalPersonRepr;
    }
}
