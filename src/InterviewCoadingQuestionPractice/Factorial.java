package InterviewCoadingQuestionPractice;

public class Factorial {
    public static void main(String[] args) {
        int n=5;
        int fact = fact(5);
        System.out.println(fact);
    }

    private static int fact(int n) {
        if(n==0) return 1;

        return n * fact(n-1);
    }
}
