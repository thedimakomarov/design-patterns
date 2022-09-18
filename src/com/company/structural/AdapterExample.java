package com.company.structural;

class FileManager {
    public void save(Object obj) {
        System.out.println("Object was saved.");
    }
    public Object load() {
        System.out.println("Object was loaded.");
        return new Object();
    }
    public void update(Object obj) {
        System.out.println("Object was updated.");
    }
    public void remove(Object obj) {
        System.out.println("Object was deleted.");
    }
}
interface CrudOperations {
    void insert(Object obj);
    Object select();
    void update(Object obj);
    void delete(Object obj);
}
class Adapter implements CrudOperations {
    private final FileManager fileManager;
    public Adapter(FileManager fileManager) {
        this.fileManager = fileManager;
    }
    @Override
    public void insert(Object obj) {
        fileManager.save(obj);
    }
    @Override
    public Object select() {
        return fileManager.load();
    }
    @Override
    public void update(Object obj) {
        fileManager.update(obj);
    }
    @Override
    public void delete(Object obj) {
        fileManager.remove(obj);
    }
}
public class AdapterExample {
    public static void main(String[] args) {
        CrudOperations crudOperations = new Adapter(new FileManager());

        crudOperations.insert(new Object());
        crudOperations.update(new Object());
        crudOperations.select();
        crudOperations.delete(new Object());
    }
}
