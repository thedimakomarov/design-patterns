package com.company.structural;


import java.util.HashMap;
import java.util.Map;

class Car {}
class Toyota extends Car {}
class Volkswagen extends Car {}

class CarFlyweightFactory {
    Map<String, Car> cars = new HashMap<>();

    public Car getCar(String carType) {
        if(cars.containsKey(carType)) {
            return cars.get(carType);
        } else {
            Car car = null;
            switch(carType) {
                case "toyota" -> {
                    car = new Toyota();
                    cars.put("toyota", car);
                }
                case "volkswagen" -> {
                    car = new Volkswagen();
                    cars.put("volkswagen", car);
                }
            };
            return car;
        }
    }
}

public class FlyweightExample {
    public static void main(String[] args) {
        CarFlyweightFactory flyweightFactory = new CarFlyweightFactory();
        for (int i = 0; i < 10; i++) {
            System.out.println(flyweightFactory.getCar("toyota"));
        }
    }
}
