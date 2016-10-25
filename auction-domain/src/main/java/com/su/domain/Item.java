package com.su.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    public Item(){

    }

    public Item(String title, String description){
        this.title = title;
        this.description = description;
    }


}
