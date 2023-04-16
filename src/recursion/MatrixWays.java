package recursion;

public class MatrixWays {
    public static void main(String[] args) {
        int count = count(3, 6);
        System.out.println(count);
    }

    public static int count(int n,int m){
        if(n==1 || m==1) return 1;

        return count(n-1,m) + count(n,m-1);
    }
}
