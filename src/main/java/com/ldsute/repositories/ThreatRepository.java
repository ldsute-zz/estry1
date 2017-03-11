package com.ldsute.repositories;

import com.ldsute.entities.Threat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by justin on 2/20/17.
 */
public interface ThreatRepository extends ElasticsearchRepository<Threat, String> {

    Page<Threat> findById(String id, Pageable pageable);

}
