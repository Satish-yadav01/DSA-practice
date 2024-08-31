package algorithm.leetcode.array.hashing;

import java.util.ArrayList;
import java.util.List;


/*
* String Encode and Decode - Medium
Solved
Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.

Please implement encode and decode

Example 1:

Input: ["neet","code","love","you"]

Output:["neet","code","love","you"]
Example 2:

Input: ["we","say",":","yes"]

Output: ["we","say",":","yes"]
Constraints:

0 <= strs.length < 100
0 <= strs[i].length < 200
strs[i] contains only UTF-8 characters.

*
* */


public class EncodeDecodeString {
    public static void main(String[] args) {
        String encode = encode(List.of("satish", "abhishek", "namna"));
        System.out.println(encode);
        List<String> decode = decode(encode);
        System.out.println(decode);
    }

    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String s : strs){
            encodedString.append(s.length()).append("#").append(s);
        }
        return encodedString.toString();
    }

    public static List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        for(int i=0; i<=str.length()-1; i++){
            int j=i;
            while(str.charAt(j) != '#') j++;
            int length = Integer.valueOf(str.substring(i,j));
            i = j + 1 + length;
            decodedList.add(str.substring(j+1,i));
            i--;
        }
        return decodedList;
    }
}
