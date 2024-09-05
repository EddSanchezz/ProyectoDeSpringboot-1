package com.metzuryprojects.co.proyectouno.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Manager manager;
    @OneToOne
    private Inventory shoesInventory;

    public Warehouse() {}

    public Warehouse( Manager manager, Inventory shoesInventory) {
        this.manager = manager;
        this.shoesInventory = shoesInventory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Inventory getShoesInventory() {
        return shoesInventory;
    }

    public void setShoesInventory(Inventory shoesInventory) {
        this.shoesInventory = shoesInventory;
    }
}
