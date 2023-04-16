package recursion;

public class JosephusProblem {
    public static void main(String[] args) {
        int jos = jos(5, 3);
        System.out.println(jos);
    }

    public static int jos(int n,int k){
        if(n==1) return 0;

        return (jos(n-1,k)+k)%n;
    }
}
