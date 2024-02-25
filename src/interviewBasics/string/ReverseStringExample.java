package interviewBasics.string;

//Q. reverse a string
public class ReverseStringExample {

    public static String reverseString(String s){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "this is new String";
        String rev = reverseString(str);
        System.out.println("rev : "+ rev);
    }
}



