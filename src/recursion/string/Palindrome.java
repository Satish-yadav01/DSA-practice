package recursion.string;

public class Palindrome {
    public static void main(String[] args) {
        String s = new String("satish");
        boolean check = isPalindrome(s);
        if (check) {
            System.out.println("palindrome");
        } else {
            System.out.println("not palindrome");
        }

    }

    private static boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
//        for (int i = 0; i < (arr.length-1)/2; i++) {
//            if(arr[i] != arr[arr.length-1-i]) return false;
//
//        }
//        return true;
        return pal(arr,0,arr.length-1);
    }

    private static boolean pal(char[] arr, int l, int r) {
        if(l>=r) return true;

        if(arr[l] != arr[r]) return false;

        return pal(arr,l+1,r-1);

    }
}
