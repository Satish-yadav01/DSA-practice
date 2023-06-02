package revision.algoPractice;

public class Fibonacci {
    public static void main(String[] args) {
        int f0=0;
        int f1 = 1;
        int n = 5;
        int f=0;
        System.out.println(f0);
        System.out.println(f1);

        while(n!=0){
            f= f0+f1;
            System.out.println(f);
            f0 = f1;
            f1 = f;
            n--;
        }
    }
}
