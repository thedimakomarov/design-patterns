package com.company.behavioral;

import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}
class Database{
    public void insert() {
        System.out.println("Inserting records ...");
    }
    public void select() {
        System.out.println("Selecting records ...");
    }
    public void update() {
        System.out.println("Updating records ...");
    }
    public void delete() {
        System.out.println("Deleting records ...");
    }
}

class DeleteCommand implements Command {
    private final Database database;
    public DeleteCommand(Database database) {
        this.database = database;
    }
    @Override
    public void execute() {
        database.delete();
    }
}
class InsertCommand implements Command {
    private final Database database;
    public InsertCommand(Database database) {
        this.database = database;
    }
    @Override
    public void execute() {
        database.insert();
    }
}
//... and other commands

public class CommandExample {
    private static final List<Command> commands = new ArrayList<>();
    public static void main(String[] args) {
        Database database = new Database();
        commands.add(new DeleteCommand(database));
        commands.add(new InsertCommand(database));

        commands.forEach(Command::execute);
    }
}
