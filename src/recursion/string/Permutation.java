package recursion.string;

import java.util.Arrays;


public class Permutation {
    public static void main(String[] args) {
        String s = "abc";
        mutation(s,0,s.length()-1);
    }

    private static void mutation(String s, int l, int r) {
        if(l == r){
            System.out.println(s);
            return;
        }

        for (int i = l; i <=r ; i++) {
            s = swap(s,l,i);
            mutation(s,l+1,r);
            s = swap(s,l,i);
        }
    }

    private static String swap(String s, int l, int i) {
//        System.out.println(s);
        char[] array = s.toCharArray();
        char temp;
        temp = array[l];
//        System.out.println("temp:"+temp);
        array[l] = array[i];
//        System.out.println("array[l]: "+array[l]);
        array[i] = temp;
//        System.out.println("array[i]: "+array[i]);

        String s1 = "";
        for (int j = 0; j < array.length; j++) {
            s1 = s1+array[j];
        }

//        System.out.println("swap "+s1);
        return s1;
    }
}
