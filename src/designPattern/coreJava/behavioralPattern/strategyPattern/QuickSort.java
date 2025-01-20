package designPattern.coreJava.behavioralPattern.strategyPattern;

import java.util.Arrays;

public class QuickSort implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        System.out.println("Using quick Sort");
        long startTime = System.nanoTime();
        Arrays.sort(array);

        long endTime = System.nanoTime(); // Record end time
        long duration = endTime - startTime; // Calculate duration

        System.out.println("Time taken: " + duration + " nanoseconds");
    }
}
