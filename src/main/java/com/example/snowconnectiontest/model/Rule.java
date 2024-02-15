package com.example.snowconnectiontest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rule")
public class Rule {
    @Id
    private String ruleId;
    private String ruleName;
    private String ruleDesc;

    public Rule() {

    }

    public Rule(String ruleId, String ruleName, String ruleDesc) {
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.ruleDesc = ruleDesc;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "ruleId='" + ruleId + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", ruleDesc='" + ruleDesc + '\'' +
                '}';
    }
}
