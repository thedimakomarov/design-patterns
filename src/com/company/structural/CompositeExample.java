package com.company.structural;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Component {
    double getPrice();
}
class Meat implements Component {
    @Override
    public double getPrice() {
        return 23.4;
    }
}
class Milk implements Component {
    @Override
    public double getPrice() {
        return 25.0;
    }
}
class Composite implements Component {
    private List<Component> components = new ArrayList<>();
    public Composite() {
    }
    public Composite(Component ... components) {
        this.components = Arrays.stream(components).toList();
    }
    public void addComponent(Component component) {
        components.add(component);
    }
    public void removeComponent(Component component) {
        components.remove(component);
    }
    @Override
    public double getPrice() {
        return components.stream().mapToDouble(Component::getPrice).sum();
    }
}
public class CompositeExample {
    public static void main(String[] args) {
        Component meat1 = new Meat();
        Component milk1 = new Milk();
        Composite basket1 = new Composite(meat1, milk1);
        System.out.println(basket1.getPrice());

        Component meat2 = new Meat();
        Component milk2 = new Milk();
        Composite basket2 = new Composite(meat2, milk2);
        System.out.println(basket2.getPrice());

        Composite basket3 = new Composite(basket1, basket2);
        System.out.println(basket3.getPrice());
    }
}
