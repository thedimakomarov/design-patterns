package com.company.behavioral;

import java.util.List;
import java.util.Objects;

interface State {
    void show();
}
class OnState implements State {
    @Override
    public void show() {
        System.out.println("ON");
    }
}
class OffState implements State {
    @Override
    public void show() {
        System.out.println("OFF");
    }
}

class Computer {
    private final List<State> states;
    private int index = 0;
    public Computer(List<State> states) {
        this.states = states.stream()
                .filter(Objects::nonNull)
                .toList();
    }
    public void switchState() {
        states.get(index).show();
        index = (index + 1) % states.size();
    }
    public void showCurrentState() {
        states.get(index).show();
    }
}
public class StateExample {
    public static void main(String[] args) {
        Computer computer = new Computer(List.of(new OnState(), new OffState()));
        for (int i = 0; i < 10; i++) {
            computer.switchState();
        }
    }
}
