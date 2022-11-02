package com.example.javacrudapi.repository;

import com.example.javacrudapi.entity.MobilityEntity;
import org.springframework.data.repository.CrudRepository;

public interface MobilityRepository extends CrudRepository<MobilityEntity, Long> {
    Iterable<MobilityEntity> getAllByAuthor_Id(Long author_id);
}
