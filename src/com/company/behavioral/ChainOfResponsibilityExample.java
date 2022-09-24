package com.company.behavioral;

record NumberMessage(int num1, int num2, String action) {}
abstract class Chain {
    protected Chain next;
    public void setNext(Chain next) {
        this.next = next;
    }
    abstract void calculate(NumberMessage message);
}
class AddChain extends Chain {
    @Override
    public void calculate(NumberMessage message) {
        var action = message.action();
        var num1 = message.num1();
        var num2 = message.num2();
        if("add".equals(action)) {
            System.out.printf("%s + %s = %s%n", num1, num2, num1 + num2);
        } else {
            if(next != null) {
                next.calculate(message);
            }
        }
    }
}
class SubtractChain extends Chain {
    @Override
    public void calculate(NumberMessage message) {
        var action = message.action();
        var num1 = message.num1();
        var num2 = message.num2();
        if("sub".equals(action)) {
            System.out.printf("%s - %s = %s%n", num1, num2, num1 - num2);
        } else {
            if(next != null) {
                next.calculate(message);
            }
        }
    }
}
class MultiplyChain extends Chain {
    @Override
    public void calculate(NumberMessage message) {
        var action = message.action();
        var num1 = message.num1();
        var num2 = message.num2();
        if("mult".equals(action)) {
            System.out.printf("%s * %s = %s%n", num1, num2, num1 * num2);
        } else {
            if(next != null) {
                next.calculate(message);
            }
        }
    }
}
class DivideChain extends Chain {
    @Override
    public void calculate(NumberMessage message) {
        var action = message.action();
        var num1 = message.num1();
        var num2 = message.num2();
        if("div".equals(action)) {
            System.out.printf("%s / %s = %s%n", num1, num2, num1 / num2);
        } else {
            if(next != null) {
                next.calculate(message);
            }
        }
    }
}
public class ChainOfResponsibilityExample {
    public static void main(String[] args) {
        Chain chain1 = new AddChain();
        Chain chain2 = new SubtractChain();
        Chain chain3 = new MultiplyChain();
        Chain chain4 = new DivideChain();

        chain1.setNext(chain2);
        chain2.setNext(chain3);
        chain3.setNext(chain4);

        NumberMessage message = new NumberMessage(4, 2, "add");
        chain1.calculate(message);

        NumberMessage message1 = new NumberMessage(4, 2, "sub");
        chain1.calculate(message1);

        NumberMessage message2 = new NumberMessage(4, 2, "mult");
        chain1.calculate(message2);

        NumberMessage message3 = new NumberMessage(4, 2, "div");
        chain1.calculate(message3);
    }
}
