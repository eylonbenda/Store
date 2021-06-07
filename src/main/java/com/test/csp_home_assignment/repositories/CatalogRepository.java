package com.test.csp_home_assignment.repositories;

import com.test.csp_home_assignment.model.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends CrudRepository<Catalog , Long> {


}
