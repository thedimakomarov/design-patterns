package com.company.structural;

abstract class Subject {
    public abstract void doSomeWork();
}
class RealSubject extends Subject {
    @Override
    public void doSomeWork() {
        System.out.println("work of real subject");
    }
}
class Proxy extends Subject {
    private RealSubject realSubject;
    @Override
    public void doSomeWork() {
        System.out.println("Proxy was here");
        ///Lazy initialization
        if (realSubject == null)
        {
            realSubject = new RealSubject();
        }
        realSubject.doSomeWork();
    }
}
public class ProxyExample {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.doSomeWork();
    }
}
