package com.test.csp_home_assignment.controllers;


import com.test.csp_home_assignment.model.Item;
import com.test.csp_home_assignment.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Item> getItem(@PathVariable Long id){

        Optional<Item> item = itemService.get(id);
        if(!item.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(item.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> addItem(@RequestBody Item item){
        //TODO:validate item
        Item item1 = itemService.save(item);
        return new ResponseEntity<>(item1.getId() , HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Long> removeItem(@RequestBody Long id){

    }

}
