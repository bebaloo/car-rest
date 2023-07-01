package com.example.carrest.service.impl;

import com.example.carrest.exception.EntityNotDeletedException;
import com.example.carrest.exception.EntityNotFoundException;
import com.example.carrest.exception.EntityNotSavedException;
import com.example.carrest.exception.EntityNotUpdatedException;
import com.example.carrest.model.entity.Car;
import com.example.carrest.repository.CarRepository;
import com.example.carrest.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {
        try {
            return carRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Car with id: " + id + " not found");
        }
    }

    @Override
    public void create(Car car) {
        try {
            carRepository.save(car);
        } catch (RuntimeException e) {
            throw new EntityNotSavedException(car + " not saved", e);
        }
    }

    @Override
    public void update(Car updatedCar) {
        try {
            Car car = carRepository.findById(updatedCar.getId()).orElseThrow(EntityNotFoundException::new);
            BeanUtils.copyProperties(updatedCar, car, "id");

            carRepository.save(car);
        } catch (RuntimeException e) {
            throw new EntityNotUpdatedException(updatedCar + " not updated", e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            Car car = carRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            carRepository.delete(car);
        } catch (RuntimeException e) {
            throw new EntityNotDeletedException("Car with id: " + id + " not deleted", e);
        }

    }
}
