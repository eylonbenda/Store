package com.test.csp_home_assignment.services;

import com.test.csp_home_assignment.model.Catalog;
import com.test.csp_home_assignment.repositories.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    public Optional<Catalog> get(Long id) {
        return catalogRepository.findById(id);
    }


    public List<Catalog> getAll() {
        return (List<Catalog>) catalogRepository.findAll();
    }
}
