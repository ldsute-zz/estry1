package com.ldsute.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ldsute.entity.Threat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justin on 2/23/17.
 */
public class ThreatList {
    private List<Threat> threatList = null;
    private String error = null;

    public ThreatList(Iterable<Threat> threatsIterable) {
        try {
            this.threatList = new ArrayList<Threat>();
            if (threatsIterable != null) {
                for (Threat threat : threatsIterable) {
                    this.threatList.add(threat);
                }
            }
        } catch (Exception e) {
            this.error = "Could not get list of threats: " + e.getMessage();
            this.threatList = null;
        }
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Threat> getThreats() {
        return this.threatList;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getError() {
        return this.error;
    }

}
