package com.test.csp_home_assignment.services;
import com.test.csp_home_assignment.model.Order;
import com.test.csp_home_assignment.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Long save(Order order){
        return orderRepository.save(order).getOrderNum();
    }

}
