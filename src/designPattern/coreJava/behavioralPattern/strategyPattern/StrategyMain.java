package designPattern.coreJava.behavioralPattern.strategyPattern;

import java.util.Arrays;

public class StrategyMain {
    public static void main(String[] args) {
        Sorter sorter = new Sorter(new BubbleSort());
        int[] sort = sorter.sort(new int[]{3, 6, 2, 8, 4, 9, 4, 6});
        System.out.println(Arrays.toString(sort));
    }
}
