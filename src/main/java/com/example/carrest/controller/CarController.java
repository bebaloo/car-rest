package com.example.carrest.controller;

import com.example.carrest.model.entity.Car;
import com.example.carrest.repository.CarRepository;
import com.example.carrest.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.get(id));
    }

    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.create(car));
    }

    @PutMapping
    public ResponseEntity<Car> update(@RequestBody Car car) {
        return ResponseEntity.ok(carService.update(car));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> delete(@PathVariable Long id) {
        return ResponseEntity.ok(carService.delete(id));
    }
}
