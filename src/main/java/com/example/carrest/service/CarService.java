package com.example.carrest.service;

import com.example.carrest.model.entity.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
    Car getById(Long id);
    void create(Car car);
    void update(Car updatedCar);
    void deleteById(Long id);
}
