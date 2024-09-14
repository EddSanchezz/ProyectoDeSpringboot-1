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
    private String color;
    private Integer Quantity;

    public Shoe() {

    }

    public Shoe( String name,  Double price, Integer size, String color, Integer quantity) {
        this.size = size;
        this.price = price;
        this.name = name;
        this.color = color;
        this.Quantity = quantity;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }
}
