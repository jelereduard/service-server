package com.example.roach.car;

import javax.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @SequenceGenerator(
            name="car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long id;
    private String make;
    private String model;
    private String color;
    private int yearOfFabrication;
    private String plate;

    public Car() {}

    public Car(String make, String model, String color, int yearOfFabrication, String plate) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.yearOfFabrication = yearOfFabrication;
        this.plate = plate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfFabrication() {
        return yearOfFabrication;
    }

    public void setYearOfFabrication(int yearOfFabrication) {
        this.yearOfFabrication = yearOfFabrication;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", yearOfFabrication=" + yearOfFabrication +
                ", plate=" + plate +
                '}';
    }
}
