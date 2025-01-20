package prcatice;

public class PalindromeString {
    public static void main(String[] args) {
        String s = "abcdedcbpqra";
//        check the string is palindrome or not
        boolean b = checkPalindrome(s);
        System.out.println("b : " + b);

    }

    private static boolean checkPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }
}
