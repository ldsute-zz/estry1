package com.ldsute.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by justin on 2/20/17.
 */
// http://localhost:9200/aclrule/aclrule/_search
@Document(indexName = "aclrule", shards = 1, replicas = 0)
public class Acl {
    @Id
    private String id;
    private String srcIp;
    private Integer srcIpMask;
    private Integer srcPort;
    private String destIp;
    private Integer destIpMask;
    private Integer destPort;
    private String ipProtocol;

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

    public Integer getSrcIpMask() {
        return srcIpMask;
    }

    public void setSrcIpMask(Integer srcIpMask) {
        this.srcIpMask = srcIpMask;
    }

    public Integer getDestIpMask() {
        return destIpMask;
    }

    public void setDestIpMask(Integer destIpMask) {
        this.destIpMask = destIpMask;
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
        return "Acl[proto=" + getIpProtocol() + " | " +
                getSrcIp() + "/" + getSrcIpMask() + ":" + getSrcPort() + " -> " +
                getDestIp() + "/" + getDestIpMask() + ":" + getDestPort() + "]";
    }
}
