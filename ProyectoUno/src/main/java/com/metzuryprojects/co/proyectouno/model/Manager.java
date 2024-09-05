package com.metzuryprojects.co.proyectouno.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Manager extends Employee{

    private String warehouseInCharge;

    public Manager() {
    }

    public Manager( String name, String lastname, String email, double salary) {
        super(name, lastname, email, salary);
    }

    public String getWarehouseInCharge() {
        return warehouseInCharge;
    }

    public void setWarehouseInCharge(String warehouseInCharge) {
        this.warehouseInCharge = warehouseInCharge;
    }
}
