package com.ldsute.repositories;

import com.ldsute.entities.AclRule;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by justin on 2/20/17.
 */
public interface AclRuleRepository extends ElasticsearchRepository<AclRule, String> {

    Page<AclRule> findById(String id, Pageable pageable);

}
