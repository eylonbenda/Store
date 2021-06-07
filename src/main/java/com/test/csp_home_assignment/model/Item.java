package com.test.csp_home_assignment.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;
    private String brand;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATALOG_KEY" , referencedColumnName = "KEY")
    private Catalog catalog;

    @ManyToMany(mappedBy = "items")
    private Set<Order> orders;

}
