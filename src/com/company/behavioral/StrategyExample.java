package com.company.behavioral;

import java.util.Arrays;

interface SortStrategy {
    void sort(int[] array);
}
class BubbleSort implements SortStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println("BubbleSort");
        Arrays.sort(array);//BubbleSort
        System.out.println(Arrays.toString(array));
    }
}
class InsertingSort implements SortStrategy{
    @Override
    public void sort(int[] array) {
        System.out.println("InsertingSort");
        Arrays.sort(array);//InsertingSort
        System.out.println(Arrays.toString(array));
    }
}

class StrategyClient {
    private SortStrategy strategy;
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    public void execute(int[] array) {
        strategy.sort(array);
    }
}

public class StrategyExample {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();

        client.setStrategy(new BubbleSort());
        int[] array1 = {1,3,2,1};
        client.execute(array1);

        client.setStrategy(new InsertingSort());
        int[] array2 = {1,3,2,1,5,6,4};
        client.execute(array2);
    }
}
