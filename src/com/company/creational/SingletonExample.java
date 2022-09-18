package com.company.creational;

class SingletonLogger {
    private static SingletonLogger singletonLogger;
    private SingletonLogger() {
        //empty private constructor
    }
    public static synchronized SingletonLogger get() {
        singletonLogger = (singletonLogger == null) ? new SingletonLogger(): singletonLogger;
        return singletonLogger;
    }
    //methods for logger
}
public class SingletonExample {
    public static void main(String[] args) {
        System.out.println(SingletonLogger.get());
        System.out.println(SingletonLogger.get());
    }
}
