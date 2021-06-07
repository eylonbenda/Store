package com.test.csp_home_assignment.controllers;


import com.test.csp_home_assignment.model.Item;
import com.test.csp_home_assignment.model.Order;
import com.test.csp_home_assignment.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/api/v1/order")
    public ResponseEntity<Long> purcase(@RequestBody List<Item> items){

        Set<Item> orderItems = new HashSet<>(items);
        double totalPrice = items.stream().mapToDouble(p -> p.getPrice()).sum();
        Order order = new Order(orderItems , totalPrice);
        Long orderNum = orderService.save(order);
        return new ResponseEntity<Long>(orderNum , HttpStatus.CREATED);
    }
}
