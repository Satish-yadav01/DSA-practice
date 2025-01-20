package designPattern.coreJava.behavioralPattern.strategyPattern;

public class BubbleSort implements SortingStrategy {

    @Override
    public void sort(int[] array) {
        System.out.println("using bubble sort");
        long startTime = System.nanoTime();

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime(); // Record end time
        long duration = endTime - startTime; // Calculate duration

        System.out.println("Time taken: " + duration + " nanoseconds");
    }
}
