package com.test.csp_home_assignment.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long orderNum;
    private Double totalPrice;
    private Date date;

    @ManyToMany
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private Set<Item> items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_KEY" , referencedColumnName = "KEY")
    private User user;

    public Order(  Set<Item> items , Double price) {
        this.items = items;
        this.totalPrice = price;
        this.date = new Date();
    }

    //private Customer customer;


}
