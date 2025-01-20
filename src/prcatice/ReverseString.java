package prcatice;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello World";
        String reverse = reverse(str); //O(n)
        System.out.println("Reversed String: " + reverse);

    }

    private static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
