package revision.algoPractice;

public class primeNumber {
    public static void main(String[] args) {
        int n = 12;
        int count = 0;
        boolean isPrime = false;
        for (int i = 2; i*i < n/2; i++) {
            count++;
            if(n%i ==0){
                isPrime = true;
                break;
            }
        }
        System.out.println("count : " + count);
        if(isPrime){
            System.out.println(n + " is not a prime");
        }else {
            System.out.println(n + " is a prime");
        }
    }
}
