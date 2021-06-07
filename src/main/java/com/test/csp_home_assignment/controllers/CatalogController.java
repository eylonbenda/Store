package com.test.csp_home_assignment.controllers;


import com.test.csp_home_assignment.model.Catalog;
import com.test.csp_home_assignment.model.Item;
import com.test.csp_home_assignment.repositories.CatalogRepository;
import com.test.csp_home_assignment.services.CatalogService;
import com.test.csp_home_assignment.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/{key}")
    public ResponseEntity<List<Item>> getCatalog(@PathVariable Long key){

        Optional<Catalog> catalog = catalogService.get(key);
        if(!catalog.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Item> items = itemService.getItemsCatalog(catalog.get());
        return new ResponseEntity<>(items,HttpStatus.OK);
    }


    @GetMapping(path = "/")
    public ResponseEntity<List<Catalog>> getCatalogs(){
        return new ResponseEntity<>(catalogService.getAll() , HttpStatus.OK);
    }

    @GetMapping(path = "/{catalogKey}/item/{itemId}")
    public ResponseEntity<Item> getItem(@PathVariable Long catalogKey
            , @PathVariable Long itemId){
        Optional<Catalog> catalog = catalogService.get(catalogKey);
        if(!catalog.isPresent())
            return new ResponseEntity<>(HttpStatus.OK);

        Optional<Item> item = itemService.getItemFromCatalog(catalog.get() , itemId);
        return item.isPresent()
                ? new ResponseEntity<>(item.get() , HttpStatus.OK)
                :  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }






}
