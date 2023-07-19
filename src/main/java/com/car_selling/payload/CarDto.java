package com.car_selling.payload;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;


@Data
public class CarDto {

    private Long id;
    private int year;
    private String make;
    private String model;
    private String trim;
    private String body;
    private String transmission;
    private String vin;
    private String state;
    private String condition;
    private int odometer;
    private String color;
    private String interior;
    private String seller;
    private double mmr;
    private double sellingPrice;
    private LocalDate saleDate;


}
