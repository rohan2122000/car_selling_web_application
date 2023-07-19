package com.car_selling.controller;

import com.car_selling.entity.Car;
import com.car_selling.payload.CarDto;
import com.car_selling.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/filter")
    public List<CarDto> filterCarsByYear(@RequestParam("year") int year) {
        List<CarDto> filteredCars = carService.getCarsByYear(year);
        return ResponseEntity.ok(filteredCars).getBody();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping
    public List<CarDto> getCarsWithinPriceRange(
            @RequestParam("minPrice") double minPrice,
            @RequestParam("maxPrice") double maxPrice) {
        List<CarDto> cars = carService.getCarsWithinPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(cars).getBody();
    }


    @PreAuthorize("hasRole('USER')")
    @GetMapping("/all")
    public List<CarDto> getAllCars(@RequestParam(value="pageNo",defaultValue = "0",required = false)int pageNo,
                                                @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize,
                                                @RequestParam(value = "sortBy",defaultValue = "id",required = false) String sortBy,
                                                @RequestParam(value = "sortDir", defaultValue = "asc",required = false) String sortDir) {
        return (List<CarDto>) carService.getAllCars(pageNo,pageSize,sortBy,sortDir);

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/make")
    public List<CarDto> filterCarsByMake(@RequestParam("make") String make) {
        List<CarDto> filteredCars = carService.getCarsByMake(make);
        return ResponseEntity.ok(filteredCars).getBody();
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/color")
    public List<CarDto> filterCarsByColor(@RequestParam("color") String color) {
        List<CarDto> filteredCars = carService.getCarsByColor(color);
        return ResponseEntity.ok(filteredCars).getBody();
    }

}

