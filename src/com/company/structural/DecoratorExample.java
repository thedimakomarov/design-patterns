package com.company.structural;

interface Printer {
    void print();
}
abstract class PrinterDecorator implements Printer {
    protected Printer printer;
    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }
    @Override
    public abstract void print();
}

class RealPrinter implements Printer {
    private final String value;
    public RealPrinter(String value) {
        this.value = value;
    }
    @Override
    public void print() {
        System.out.print(value);
    }
}

class BracketPrinterDecorator extends PrinterDecorator {
    public BracketPrinterDecorator(Printer printer) {
        super(printer);
    }
    @Override
    public void print() {
        System.out.print("(");
        printer.print();
        System.out.print(")");
    }
}
public class DecoratorExample {
    public static void main(String[] args) {
        Printer printer = new BracketPrinterDecorator(new RealPrinter("word"));
        printer.print();
    }
}
