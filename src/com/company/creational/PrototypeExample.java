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
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class PrototypeExample {
    public static void main(String[] args) throws CloneNotSupportedException {
        Project original = new Project(1, "pr", 1.0);
        Project clone = (Project) original.clone();
        clone.setId(2);
        System.out.println(original);
        System.out.println(clone);
    }
}
