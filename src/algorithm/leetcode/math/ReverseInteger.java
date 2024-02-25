package algorithm.leetcode.math;

public class ReverseInteger {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println("x : " + x);

//        int reverse = reverse(x);
        var reverse = rev(x);
        System.out.println("reverse : " + reverse);
    }

    public static int reverse(int x) {
        if(x == 0){
            return 0;
        }

        StringBuilder sbr = new StringBuilder(""+Math.abs(x));
        StringBuilder reverse = sbr.reverse();

//        System.out.println("sbr : " + sbr);
        StringBuilder result = new StringBuilder();


        if(x < 0){
            return -1 * Integer.parseInt(reverse.toString());
        }
        System.out.println(Integer.parseInt(reverse.toString()));
        return Integer.parseInt(reverse.toString());
    }

    static long rev(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        return Integer.parseInt(sb.reverse().toString());
    }
}
