package com.company.behavioral;

import java.util.ArrayList;
import java.util.List;

interface User {
    void sendMessage(String message);
    void getMessage(String message);
}
class RealUser implements User{
    GroupChat groupChat;
    String name;
    public RealUser(GroupChat groupChat, String name) {
        this.groupChat = groupChat;
        this.name = name;
    }
    @Override
    public void sendMessage(String message) {
        groupChat.sendMessage(message, this);
    }
    @Override
    public void getMessage(String message) {
        System.out.println(name + " has got message(\"" + message + "\")");
    }

    @Override
    public String toString() {
        return name;
    }
}
interface GroupChat {
    void sendMessage(String message, User user);
}
class Telegram implements GroupChat {
    List<User> allUsers = new ArrayList<>();
    public void addUserToChat(User user) {
        allUsers.add(user);
    }
    @Override
    public void sendMessage(String message, User user) {
        System.out.println(user + ": " + message);
        allUsers.stream()
                .filter(u -> u != user)
                .forEach(u -> u.getMessage(message));
    }
}
public class MediatorExample {
    public static void main(String[] args) {
        Telegram telegram = new Telegram();

        User bob = new RealUser(telegram, "bob");
        User anna = new RealUser(telegram, "anna");
        User leo = new RealUser(telegram, "leo");

        telegram.addUserToChat(bob);
        telegram.addUserToChat(anna);
        telegram.addUserToChat(leo);

        bob.sendMessage("Hi, guys");
    }
}
