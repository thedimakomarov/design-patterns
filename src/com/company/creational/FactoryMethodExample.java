package com.company.creational;

interface Animal {
    void speak();
}
class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("weo-weo");
    }
}
class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("gaf-gaf");
    }
}
abstract class Factory<T> {
    public abstract T getByType(String type);
}
class AnimalFactory extends Factory<Animal> {
    @Override
    public Animal getByType(String type) {
        return switch(type) {
            case "cat" -> new Cat();
            case "dog" -> new Dog();
            default -> throw new RuntimeException(String.format("Animal type : %s cannot be instantiated", type));
        };
    }
}
public class FactoryMethodExample {
    public static void main(String[] args) {
        Factory<Animal> animalFactory = new AnimalFactory();

        Animal cat = animalFactory.getByType("cat");
        cat.speak();

        Animal dog = animalFactory.getByType("dog");
        dog.speak();

        //There is no Lion type. So, an exception will be thrown
        Animal lion = animalFactory.getByType("lion");
        lion.speak();
    }
}
