package com.test.csp_home_assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Catalog {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long key;
    private String type;


    //private List<Item> items;


}
