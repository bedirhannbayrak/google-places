package com.bedirhan.google.places.api.service;

import com.bedirhan.google.places.api.model.Query;
import com.bedirhan.google.places.api.repository.QueryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryService {
    private final QueryDao queryDao;

    public Query findByName(String name) {
        return queryDao.findByName(name);
    }

    public void save(Query query) {
        Query save = queryDao.save(query);
    }

    public boolean existByName(String name) {
        return queryDao.existsByName(name);
    }

}

