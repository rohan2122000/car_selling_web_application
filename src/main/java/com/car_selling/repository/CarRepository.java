package com.car_selling.repository;

import com.car_selling.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByYear(int year);

    List<Car> findBySellingPriceBetween(double minPrice, double maxPrice);

    List<Car> findByMake(String make);

    List<Car> findByColor(String color);
}

