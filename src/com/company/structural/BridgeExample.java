package com.company.structural;

interface Color {
    void showColor();
}
class Green implements Color {
    @Override
    public void showColor() {
        System.out.print("Green");
    }
}
class Red implements Color {
    @Override
    public void showColor() {
        System.out.print("Red");
    }
}

abstract class Figure {
    private Color color;
    public Figure(Color color) {
        this.color = color;
    }
    public void showFullInfo() {
        color.showColor();
        System.out.print(" ");
        showFigure();
        System.out.println();
    }
    abstract void showFigure();
}
class Circle extends Figure {
    public Circle(Color color) {
        super(color);
    }
    @Override
    void showFigure() {
        System.out.print("Circle");
    }
}
class Square extends Figure {
    public Square(Color color) {
        super(color);
    }
    @Override
    void showFigure() {
        System.out.print("Square");
    }
}
public class BridgeExample {
    public static void main(String[] args) {
        Figure square = new Square(new Green());
        square.showFullInfo();

        Figure circle = new Circle(new Red());
        circle.showFullInfo();
    }
}
