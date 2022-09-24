package com.company.behavioral;

record GameMemento(String level, int time) {}
class File {
    private final GameMemento memento;
    public File(GameMemento memento) {
        this.memento = memento;
    }
    public GameMemento getMemento() {
        return memento;
    }
}
class Game {
    private String level;
    private int time;
    public Game(String level, int time) {
        this.level = level;
        this.time = time;
    }
    public void load(GameMemento memento) {
        level = memento.level();
        time = memento.time();
    }
    public GameMemento save() {
        return new GameMemento(level, time);
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public void setTime(int time) {
        this.time = time;
    }
    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", time=" + time +
                '}';
    }
}
public class MementoExample {
    public static void main(String[] args) {
        Game game = new Game("lvl1", 4);
        System.out.println(game);

        File file = new File(game.save());

        game.setLevel("lvl3");
        game.setTime(10);
        System.out.println(game);

        //загружаем игру с сохранения
        game.load(file.getMemento());
        System.out.println(game);
    }
}
