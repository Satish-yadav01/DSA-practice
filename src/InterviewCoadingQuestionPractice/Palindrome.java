package InterviewCoadingQuestionPractice;

public class Palindrome {
    public static void main(String[] args) {
        String s = "abcsba";
        if(isPalindrome(s)){
            System.out.println("palindrome");
        }else{
            System.out.println("not palindrome");
        }
    }

    private static boolean isPalindrome(String s) {
        return s.equals(new StringBuffer(s).reverse().toString());
    }
}
