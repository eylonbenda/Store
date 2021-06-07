package com.test.csp_home_assignment.services;


import com.test.csp_home_assignment.model.Catalog;
import com.test.csp_home_assignment.model.Item;
import com.test.csp_home_assignment.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;


    public Optional<Item> get(Long id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
         return itemRepository.save(item);
    }
    public void remove(Item item) {
        itemRepository.delete(item);
    }

    public List<Item> getItemsCatalog(Catalog catalog) {
        return itemRepository.findByCatalog(catalog);
    }


    public Optional<Item> getItemFromCatalog(Catalog catalog , Long itemId) {
        List<Item> items =  itemRepository.findByCatalog(catalog);
        return items.stream()
                .filter(item -> item.getId().equals(itemId))
                .findAny();

    }
}
