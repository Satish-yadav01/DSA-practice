package sorting;

public class BubbleSortAlgo {
    public static void main(String[] args) {
        int a[] = new int[]{1,3,2,6,5,4,8,6,7};
        for(int i=0;i<=a.length-1;i++){
            for (int j = 0; j < (a.length-i-1); j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        displaySort(a);
    }

    private static void displaySort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
