package com.car_selling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_prices")
public class Car {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "sellingprice")
    private double sellingPrice;
    private LocalDate saleDate;


}

