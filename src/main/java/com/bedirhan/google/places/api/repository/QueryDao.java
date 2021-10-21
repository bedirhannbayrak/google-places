package com.bedirhan.google.places.api.repository;

import com.bedirhan.google.places.api.model.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryDao extends JpaRepository<Query,Integer> {
    Query findByName(String name);
    boolean existsByName(String name);
}
