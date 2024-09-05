package com.metzuryprojects.co.proyectouno.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;


@Entity
public class Inventory {

    @Id
    private Long id;

    @OneToMany
    private List<Shoe> shoe;

    public Inventory( List<Shoe> shoe) {

        this.shoe = shoe;
    }

    public Inventory() {}

    public List<Shoe> getShoe() {
        return shoe;
    }

    public void setShoe(List<Shoe> shoe) {
        this.shoe = shoe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
