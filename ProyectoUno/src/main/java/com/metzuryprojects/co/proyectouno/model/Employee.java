package com.metzuryprojects.co.proyectouno.model;

import jakarta.persistence.Entity;

@Entity
public class Employee extends Person{

    private double salary;
    private int yearsWorking = 0;

    public Employee() {}

    public Employee(String name, String lastname, String email, double salary) {
        super(name, lastname, email);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYearsWorking() {
        return yearsWorking;
    }

    public void setYearsWorking(int yearsWorking) {
        this.yearsWorking = yearsWorking;
    }
}
