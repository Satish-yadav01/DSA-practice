package algorithm.leetcode.string;

import java.util.Arrays;

public class Defanging {
    public static void main(String[] args) {
        String s = defangIPaddr("1.1.1.1");
        System.out.println("s : "+ s);

    }

    public static String defangIPaddr(String address) {
        String[] split = address.split(".");
        System.out.println("sdsd");
        Arrays.toString(split);
         StringBuilder sbr = new StringBuilder();
//        String s="";

        for(int i=0; i<=split.length-1; i++){
//            s = split[i] + "[.]";
//            System.out.println(s);

            sbr.append(split[i]+"[.]");
        }
        System.out.println(sbr.toString());
        return sbr.toString();
    }
}
