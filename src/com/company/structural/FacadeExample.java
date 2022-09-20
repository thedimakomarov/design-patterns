package com.company.structural;

class RobotMaterial {
    private String material;
    public RobotMaterial(String material) {
        this.material = material;
    }
    @Override
    public String toString() {
        return material;
    }
}
class RobotColor {
    private String color;
    public RobotColor(String color) {
        this.color = color;
    }
    @Override
    public String toString() {
        return color;
    }
}
class Robot {
    private RobotMaterial robotMaterial;
    private RobotColor robotColor;
    public Robot(RobotColor robotColor, RobotMaterial robotMaterial) {
        this.robotMaterial = robotMaterial;
        this.robotColor = robotColor;
    }
    @Override
    public String toString() {
        return String.format("%s %s robot was created.", robotColor.toString().toLowerCase(), robotMaterial.toString().toLowerCase());
    }
}

class RobotFacade {
    public Robot createRobot(String color, String material) {
        RobotColor robotColor = new RobotColor(color);
        RobotMaterial robotMaterial = new RobotMaterial(material);
        Robot robot = new Robot(robotColor, robotMaterial);
        return robot;
    }
}

public class FacadeExample {
    public static void main(String[] args) {
        RobotFacade robotFacade = new RobotFacade();
        Robot greenIronRobot = robotFacade.createRobot("Green", "Iron");
        System.out.println(greenIronRobot);

        Robot redIronRobot = robotFacade.createRobot("Red", "Iron");
        System.out.println(redIronRobot);
    }
}
