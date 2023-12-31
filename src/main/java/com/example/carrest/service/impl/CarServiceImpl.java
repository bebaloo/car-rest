package com.example.carrest.service.impl;

import com.example.carrest.exception.EntityNotDeletedException;
import com.example.carrest.exception.EntityNotFoundException;
import com.example.carrest.exception.EntityNotCreatedException;
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
    private final CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car get(Long id) {
        try {
            return carRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Car with id: " + id + " not found");
        }
    }

    @Override
    public Car create(Car car) {
        try {
            return carRepository.save(car);
        } catch (RuntimeException e) {
            throw new EntityNotCreatedException(car + " not saved", e);
        }
    }

    @Override
    public Car update(Car updatedCar) {
        try {
            Car car = carRepository.findById(updatedCar.getId()).orElseThrow(EntityNotFoundException::new);
            BeanUtils.copyProperties(updatedCar, car, "id");

            return carRepository.save(car);
        } catch (RuntimeException e) {
            throw new EntityNotUpdatedException(updatedCar + " not updated", e);
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Car car = carRepository.findById(id).orElseThrow(EntityNotFoundException::new);
            carRepository.delete(car);
        } catch (RuntimeException e) {
            throw new EntityNotDeletedException("Car with id: " + id + " not deleted", e);
        }
    }
}
