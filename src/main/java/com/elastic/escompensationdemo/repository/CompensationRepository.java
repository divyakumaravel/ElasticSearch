package com.elastic.escompensationdemo.repository;

import com.elastic.escompensationdemo.model.Compensation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CompensationRepository extends ElasticsearchRepository<Compensation, String> {
    Page<Compensation> findByTotalCompensationAndCity(Double totalCompensation, String city, Pageable pageable);
}
