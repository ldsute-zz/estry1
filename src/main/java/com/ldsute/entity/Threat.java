package com.ldsute.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justin on 3/11/17.
 */
// http://localhost:9200/threat/threat/_search
@Document(indexName = "threat", shards = 1, replicas = 0)
public class Threat {
    @Id
    private String id;
    @JsonProperty("acl")
    List<Acl> aclList;
    @JsonProperty("url")
    List<String> urlList;
    @JsonProperty("fqdn")
    List<String> fqdnList;
    @JsonProperty("regex")
    List<String> regexList;

    public Threat() {
        aclList = new ArrayList<>();
        urlList = new ArrayList<>();
        fqdnList = new ArrayList<>();
        regexList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addAcl(Acl acl) {
        this.aclList.add(acl);
    }

    public void addUrl(String url) {
        this.urlList.add(url);
    }

    public void addFqdn(String fqdn) {
        this.fqdnList.add(fqdn);
    }

    public void addRegex(String regex) {
        this.regexList.add(regex);
    }

    public List<Acl> getAclList() {
        return aclList;
    }

    public List<String> getUrlList() {
        return urlList;
    }

    public List<String> getFqdnList() {
        return fqdnList;
    }

    public List<String> getRegexList() {
        return regexList;
    }
}
