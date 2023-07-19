package com.car_selling.service.impl;

import com.car_selling.entity.Car;
import com.car_selling.payload.CarDto;
import com.car_selling.repository.CarRepository;
import com.car_selling.service.CarService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    private ModelMapper mapper;

    public CarServiceImpl(CarRepository carRepository, ModelMapper mapper) {
        this.carRepository = carRepository;
        this.mapper = mapper;
    }

    @Override
    public List<CarDto> getCarsByYear(int year) {
        List<Car> cars = carRepository.findByYear(year);
        return cars.stream().map(car -> mapToDto(car)).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarsByMake(String make) {
        List<Car> cars = carRepository.findByMake(make);
        return cars.stream().map(car -> mapToDto(car)).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarsWithinPriceRange(double minPrice, double maxPrice) {
        List<Car> cars = carRepository.findBySellingPriceBetween(minPrice, maxPrice);
        return cars.stream().map(car -> mapToDto(car)).collect(Collectors.toList());
    }

    @Override
    public List<CarDto> getCarsByColor(String color) {
        List<Car> cars = carRepository.findByColor(color);
        return cars.stream().map(car -> mapToDto(car)).collect(Collectors.toList());
    }



    @Override
    public List<CarDto> getAllCars(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        PageRequest pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Car> content = carRepository.findAll(pageable);
        List<Car> cars = content.getContent();
        return cars.stream().map(car -> mapToDto(car)).collect(Collectors.toList());
    }


    Car mapToEntity(CarDto postDto) {
        Car car = mapper.map(postDto,Car.class);
        return car;
    }

    CarDto mapToDto(Car post){
        CarDto carDto = mapper.map(post, CarDto.class);
        return carDto;
    }

}

