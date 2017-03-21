package com.ldsute.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by hungnguyen on 12/16/14.
 */
@Configuration
@PropertySource(value = "classpath:elasticsearch.properties")
@EnableElasticsearchRepositories(basePackages = "com.ldsute.repository")
public class ElasticsearchConfiguration {
    @Resource
    private Environment environment;

    @Bean
    public Client client() throws UnknownHostException {
        return TransportClient.builder().build().addTransportAddress(
                new InetSocketTransportAddress(
                    InetAddress.getByName(environment.getProperty("elasticsearch.host")),
                    Integer.parseInt(environment.getProperty("elasticsearch.port"))));
    }
}
