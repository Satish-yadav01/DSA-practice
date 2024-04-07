package gfg.maths;

import static gfg.maths.Factorial.fact;

public class TrailingZerosInFact {
    public static void main(String[] args) {
        long trailingZeros = trailingZeros(100);
        System.out.println("count : " + trailingZeros);

        System.out.println(trailingZeros2(251));
    }

    //naive approach  -> not able to store long factorial here in this approach whereas new approach just giving the trailing zeros without calculating factorials
    private static long trailingZeros(int n) {
        int trailingCount=0;
        long fact = fact(n);
        System.out.println("fact : " + fact);
        for (int i = 0; i <= fact - 1; i++) {
            if(fact%10 ==0){
                trailingCount++;
            }
            fact = fact/10;
        }
        return trailingCount;
    }


    //O(logn)
    public static int trailingZeros2(int n){
        int res=0;
        for(int i=5; i<=n; i=i*5){
            res= res + n/i;
        }
        return res;
    }
}
