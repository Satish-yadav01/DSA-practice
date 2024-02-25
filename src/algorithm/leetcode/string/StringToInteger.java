package algorithm.leetcode.string;

public class StringToInteger {
    public static void main(String[] args) {
        int i = myAtoi("4193 with words");
        System.out.println("i: " + i);
    }

    public static int myAtoi(String s) {
        //edge cases
        if(s==null || s.length() ==0){
            return 0;
        }

        s = s.trim();
        if(s.isEmpty()){
            return 0;
        }

        char sign = '+';
        int i=0;
        if(s.charAt(0) == '+' || s.charAt(0) == '-'){
            sign = s.charAt(0);
            i++;
        }

        long result=0;
        while(i<=s.length()-1 && Character.isDigit(s.charAt(i))){
            result = result * 10 + (s.charAt(i) - '0');

            if(sign == '+' && result > Integer.MAX_VALUE ){
                return Integer.MAX_VALUE;
            }

            if(sign == '-' && -result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }

            i++;
        }

        // return (int) (sign == '-' : -result ? result);
        return (int) (sign == '-' ? -result : result);
    }
}
