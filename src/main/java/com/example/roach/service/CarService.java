package com.example.roach.service;

import com.example.carService.car.Car;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CarService {
    @Id
    @SequenceGenerator(
            name="service_sequence",
            sequenceName = "service_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "service_sequence"
    )
    private Long id;
    private String name;
    private int maxCapacity;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Car> cars;

    private int noCars;

    public CarService() {}

    public CarService(String name, int maxCapacity, List<Car> cars) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.cars = cars;
        setNoCars(cars.size());
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

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getNoCars() {
        return noCars;
    }

    public void setNoCars(int noCars) {
        this.noCars = noCars;
    }

    @Override
    public String toString() {
        return "CarService{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", cars=" + cars +
                '}';
    }
}
