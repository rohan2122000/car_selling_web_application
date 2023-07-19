package com.car_selling.service;

import com.car_selling.entity.Car;
import com.car_selling.payload.CarDto;

import java.util.List;

public interface CarService {
    List<CarDto> getCarsByYear(int year);

    List<CarDto> getCarsByMake(String make);

    List<CarDto> getCarsWithinPriceRange(double minPrice, double maxPrice);

    List<CarDto> getCarsByColor(String color);

    List<CarDto> getAllCars(int pageNo, int pageSize, String sortBy, String sortDir);


}
