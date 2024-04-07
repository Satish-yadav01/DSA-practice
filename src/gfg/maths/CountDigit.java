package gfg.maths;

public class CountDigit {
    public static void main(String[] args) {
        int n=92350000;
        int countDigit = countDigit(n);
        System.out.println("count : " + countDigit);


    }

    public static int countDigit(int n){
        int count=0;
        for(int i=0; i<=n-1; i++){
            n=n/10;
            count++;
        }
        return count;
    }
}
