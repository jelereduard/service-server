package com.example.roach.service;

import com.example.carService.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceService {
    private final CarServiceRepository carServiceRepository;

    @Autowired
    public CarServiceService(CarServiceRepository carServiceRepository) {
        this.carServiceRepository = carServiceRepository;
    }

    public List<CarService> getServiceList() {
        return carServiceRepository.findAll();
    }

    public List<Car> getCarsInService(String name) {
        return carServiceRepository.findServiceByName(name).get().getCars();
    }

    public List<Car> getCarsInService(Long id) {
        return carServiceRepository.getById(id).getCars();
    }

    public void deleteService(Long serviceId) {
        if (carServiceRepository.existsById(serviceId)) {
            carServiceRepository.deleteById(serviceId);
        } else {
            throw new IllegalStateException("service with id: " + serviceId + " does not exist");
        }
    }

    public CarService getService(Long id) {
        if(carServiceRepository.existsById(id)) {
            return carServiceRepository.findById(id).get();
        } else {
            throw new IllegalStateException("service with id: " + id + " does not exist");
        }
    }

    public Car addCarToService(Car car, Long id) {
        if(carServiceRepository.existsById(id)) {
            CarService carService = carServiceRepository.getById(id);
            if(carService.getCars().size() >= carService.getMaxCapacity()) {
                throw new IllegalStateException("Maximum capacity reached");
            }
            List<Car> cars = carService.getCars();
            cars.add(car);
            carService.setCars(cars);
            carService.setNoCars(carService.getCars().size());
            carServiceRepository.save(carService);
            return car;
        } else {
            throw new IllegalStateException("service with id: " + id + " does not exist");
        }
    }


    public void deleteCarFromService(Long serviceId, Long carId) {
        if(carServiceRepository.existsById(serviceId)) {
            CarService carService = carServiceRepository.getById(serviceId);
            List<Car> cars = new ArrayList<>(carService.getCars());
            cars.forEach(car -> {
                if(car.getId().equals(carId)) {
                    carService.getCars().remove(car);
                }
            });
            carService.setNoCars(carService.getCars().size());
            carServiceRepository.save(carService);
        } else {
            throw new IllegalStateException("service with id: " + serviceId + " does not exist");
        }
    }
}
