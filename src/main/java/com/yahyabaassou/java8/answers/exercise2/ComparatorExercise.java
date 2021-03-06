package com.yahyabaassou.java8.answers.exercise2;

import com.yahyabaassou.java8.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorExercise {

    private static final List<Car> CARS = new ArrayList<>(Arrays.asList(
            new Car("Honda", "Accord", 190, "Japan"),
            new Car("Lexus", "Rx 350", 200, "Japan"),
            new Car("Mazda", "6", 205, "Japan"),
            new Car("Toyota", "Corolla", 180, "Japan"),
            new Car("Proton", "X70", 180, "Malaysia"),
            new Car("Hyundai", "i20", 170, "South Korea"),
            new Car("Kia", "Ceed", 210, "South Korea"),
            new Car("Renault", "Captur", 192, "France"),
            new Car("Peugeot", "308", 254, "France"),
            new Car("Citroen", "C4", 190, "France")
    ));


    //Use stream to return the fastest model from the CARS list
    public String getFastestCarModel() {
        return CARS.stream()
            .sorted(Comparator.comparingDouble(Car::getMaxSpeed).reversed())
            .map(Car::getModel)
            .limit(1)
            .findFirst()
            .orElse(null);
    }

    //Use stream to return the fastest model from the CARS list
    public List<String> getThe3FastestCountries() {
        return CARS.stream()
                .sorted(Comparator.comparingDouble(Car::getMaxSpeed).reversed())
                .map(Car::getCountry)
                .limit(3)
                .collect(Collectors.toList());
    }


}
