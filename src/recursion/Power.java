package recursion;

//calculate a^b using recursion
public class Power {
    public static void main(String[] args) {
        long power = power(234, 12);
        System.out.println(power);
    }

    public static long power(long a,long b){
        if(b==0) return 1;
        return a*power(a,b-1);
    }
}
