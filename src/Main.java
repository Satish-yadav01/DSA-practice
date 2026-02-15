import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Count frequency of s1
        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int windowSize = s1.length();

        for (int i = 0; i < s2.length(); i++) {
            // add current character
            freq2[s2.charAt(i) - 'a']++;

            // remove character going out of window
            if (i >= windowSize) {
                freq2[s2.charAt(i - windowSize) - 'a']--;
            }

            // compare frequencies
            if (matches(freq1, freq2)) return true;

        }

        return false;
    }

    private static boolean matches(int []a, int []b){
        for(int i=0; i<26; i++){
            if(a[i] != b[i]) return false;
        }

        return true;
    }
}



public class Main {
    public static void main(String[] args) {
        boolean inclusion = Solution.checkInclusion("ab", "eidbaooo");
        System.out.println("Inclusion: " + inclusion);

    }
}