package revision.algoPractice;
//Write a Java Program to count the number of words in a string using HashMap.

import java.util.Arrays;
import java.util.HashMap;

public class CountString {
    public static void main(String[] args) {
        String str = "This this is is done by Saket Saket";
        String[] s = str.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
//        Arrays.stream(s).forEach(word->{
//            return !map.containsKey(word)?map.put(word,1):map.put(word,map.get(word)+1);
//        });

        for (int i = 0; i < s.length; i++) {
            if(map.containsKey(s[i])){
                map.put(s[i],map.get(s[i])+1);
            }else{
                map.put(s[i],1);
            }
        }

        System.out.println(map);
    }
}
