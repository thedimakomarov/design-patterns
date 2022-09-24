package com.company.behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

interface Observer {
    void handle(int temperature, int pressure);
}
class News implements Observer {
    @Override
    public void handle(int temperature, int pressure) {
        System.out.printf("Weather: temperature - %d, pressure - %d%n", temperature, pressure);
    }
}

interface Observed {
    void add(Observer o);
    void remove(Observer o);
    void notifyObservers();
}
class MeteorologicalStation implements Observed {
    private int temperature;
    private int pressure;
    private final List<Observer> observers = new ArrayList<>();
    public void measure() {
        temperature = new Random().nextInt();
        pressure = new Random().nextInt();
        notifyObservers();
    }
    @Override
    public void add(Observer o) {
        observers.add(o);
    }
    @Override
    public void remove(Observer o) {
        observers.remove(o);
    }
    @Override
    public void notifyObservers() {
        observers.forEach(o -> o.handle(temperature, pressure));
    }
}
public class ObserverExample {
    public static void main(String[] args) {
        MeteorologicalStation station = new MeteorologicalStation();
        station.add(new News());

        station.measure();
    }
}
