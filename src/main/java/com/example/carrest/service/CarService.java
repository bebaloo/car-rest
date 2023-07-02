package com.example.carrest.service;

import com.example.carrest.model.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car get(Long id);

    Car create(Car car);

    Car update(Car updatedCar);

    void delete(Long id);
}
