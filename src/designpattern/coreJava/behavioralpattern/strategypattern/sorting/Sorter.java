package designpattern.coreJava.behavioralpattern.strategypattern.sorting;

public class Sorter {
    private final SortingStrategy sortingStrategy;

    public Sorter(SortingStrategy sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public int[] sort(int[] array) {
        sortingStrategy.sort(array);
        return array;
    }
}
