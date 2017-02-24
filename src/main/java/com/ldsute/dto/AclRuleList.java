package com.ldsute.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ldsute.entities.AclRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justin on 2/23/17.
 */
public class AclRuleList {
    private List<AclRule> aclRules = null;
    private String error = null;

    public AclRuleList(Iterable<AclRule> rules) {
        try {
            this.aclRules = new ArrayList<AclRule>();
            if (rules != null) {
                for (AclRule rule : rules) {
                    aclRules.add(rule);
                }
            }
        } catch (Exception e) {
            this.error = "Could not get list of rules: " + e.getMessage();
            this.aclRules = null;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<AclRule> getAclRules() {
        return this.aclRules;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getError() {
        return this.error;
    }

}
