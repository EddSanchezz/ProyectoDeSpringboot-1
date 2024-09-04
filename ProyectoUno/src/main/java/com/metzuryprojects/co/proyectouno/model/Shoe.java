package com.metzuryprojects.co.proyectouno.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Shoe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer size;

    public Shoe() {

    }

    public Shoe(Long id, Integer size, Double precio, String modelName) {
        this.id = id;
        this.size = size;
        this.price = precio;
        this.name = modelName;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String modelName) {
        this.name = modelName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double precio) {
        this.price = precio;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
