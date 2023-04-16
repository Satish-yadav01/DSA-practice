package recursion;

public class NaturalNumber {
    public static void main(String[] args) {
        int sumOfNaturalNumber = findSumOfNaturalNumber(5);
        System.out.println(sumOfNaturalNumber);
        int sum = 0;

    }
    static int findSumOfNaturalNumber(int n){
        if(n==1) return 1;
        return n + findSumOfNaturalNumber(n-1);
    }
}
