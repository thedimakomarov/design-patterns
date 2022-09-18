package com.company.creational;

class Project implements Cloneable{
    private int id;
    private String name;
    private double version;
    public Project(int id, String name, double version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVersion(double version) {
        this.version = version;
    }
    //getters
    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", version=" + version +
                '}';
    }
    @Override
    protected Project clone() {
        return new Project(this.id, this.name, this.version);
    }
}

public class PrototypeExample {
    public static void main(String[] args) {
        Project original = new Project(1, "pr", 1.0);
        Project clone = original.clone();
        clone.setId(2);
        System.out.println(original);
        System.out.println(clone);
    }
}
