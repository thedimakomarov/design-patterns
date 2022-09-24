package com.company.behavioral;

import java.util.Arrays;

interface Visitor {
    void visit(CodeWriting codeWriting);
    void visit(CodeTesting codeTesting);
}

interface Task {
    void accept(Visitor visitor);
}
class CodeWriting implements Task {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class CodeTesting implements Task {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class JuniorVisitor implements Visitor {
    @Override
    public void visit(CodeWriting codeWriting) {
        System.out.println("Junior wrote code 2 hours.");
    }
    @Override
    public void visit(CodeTesting codeTesting) {
        System.out.println("Junior tested code 4 hours.");
    }
}
class SeniorVisitor implements Visitor {
    @Override
    public void visit(CodeWriting codeWriting) {
        System.out.println("Senior wrote code 0.5 hours.");
    }
    @Override
    public void visit(CodeTesting codeTesting) {
        System.out.println("Senior tested code 1 hours.");
    }
}

class Work implements Task {
    Task[] elements;
    public Work() {
        elements = new Task[]{new CodeWriting(), new CodeTesting()};
    }
    @Override
    public void accept(Visitor visitor) {
        Arrays.asList(elements).forEach(el -> el.accept(visitor));
    }
}
public class VisitorExample {
    public static void main(String[] args) {
        Visitor junior = new JuniorVisitor();
        Visitor senior = new SeniorVisitor();

        Work work = new Work();
        work.accept(junior);
        System.out.println();
        work.accept(senior);
    }
}
