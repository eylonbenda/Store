package com.test.csp_home_assignment.repositories;


import com.test.csp_home_assignment.model.Catalog;
import com.test.csp_home_assignment.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {

    List<Item> findByBrand(String brand);

    List<Item> findByCatalog(Catalog catalog);
}
