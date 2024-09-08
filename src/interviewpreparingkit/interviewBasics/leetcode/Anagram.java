package interviewBasics.leetcode;


import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sarray = s.toLowerCase().toCharArray();
        char[] tarray = t.toLowerCase().toCharArray();

        Arrays.sort(sarray);
        Arrays.sort(tarray);

        Arrays.toString(sarray);
        System.out.println(sarray);
        Arrays.toString(tarray);
        System.out.println(tarray);

        return Arrays.equals(sarray,tarray);
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        if(isAnagram(s,t)){
            System.out.println("anagram");
        }else{
            System.out.println("not an anagram");
        }
    }
}
