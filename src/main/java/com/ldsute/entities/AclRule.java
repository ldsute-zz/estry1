package com.ldsute.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by justin on 2/20/17.
 */
// http://localhost:9200/aclrule/aclrule/_search
@Document(indexName = "aclrule", shards = 1, replicas = 0)
public class AclRule {
    @Id
    private String id;
    private String srcIp;
    private Integer srcPort;
    private String destIp;
    private Integer destPort;
    private String ipProtocol;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrcIp() {
        return srcIp;
    }

    public void setSrcIp(String srcIp) {
        this.srcIp = srcIp;
    }

    public Integer getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(Integer srcPort) {
        this.srcPort = srcPort;
    }

    public String getDestIp() {
        return destIp;
    }

    public void setDestIp(String destIp) {
        this.destIp = destIp;
    }

    public Integer getDestPort() {
        return destPort;
    }

    public void setDestPort(Integer destPort) {
        this.destPort = destPort;
    }

    public String getIpProtocol() {
        return ipProtocol;
    }

    public void setIpProtocol(String ipProtocol) {
        this.ipProtocol = ipProtocol;
    }

    @Override
    public String toString() {
        return "AclRule[id=" + getId() + ", proto=" + getIpProtocol() + " | " +
                getSrcIp() + ":" + getSrcPort() + " -> " +
                getDestIp() + ":" + getDestPort() + "]";
    }
}
