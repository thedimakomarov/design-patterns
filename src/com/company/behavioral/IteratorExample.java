package com.company.behavioral;

interface Iterator {
    boolean hasNext();
    Object next();
}
interface IteratorCreator {
    Iterator getIterator();
}
class ActionContainer implements IteratorCreator {
    String[] actions;
    public ActionContainer(String[] actions) {
        this.actions = actions;
    }
    @Override
    public Iterator getIterator() {
        return new ActionIterator();
    }
    public class ActionIterator implements Iterator {
        private int index = 0;
        @Override
        public boolean hasNext() {
            return index < actions.length;
        }
        @Override
        public Object next() {
            return actions[index++];
        }
    }
}
public class IteratorExample {
    public static void main(String[] args) {
        ActionContainer container = new ActionContainer(new String[]{"work", "drink", "fly"});

        Iterator iter = container.getIterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
