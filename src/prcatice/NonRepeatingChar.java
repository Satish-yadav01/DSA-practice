package prcatice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String str = "aabbcccdefg";
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                sb.append(entry.getKey()).append(",");
            }
        }

        System.out.println("sb : "+sb);
        String[] split = sb.toString().split(",");

        System.out.println("split : " + Arrays.toString(split));
    }
}


/*---Observation--


Time Complexity -> O(n)
Space Complexity -> O(n)
HashMap -> I used because I don't need to manage  insertion order and key order, and just because HashMap is not maintaining those that's why it is fast look up

Map --->
HashMap -> no order, no thread safe , fast operations, faster than everyMap
TreeMap ->  no thread safe, key order maintain,
LinkedHashMap -> no thread safe, insertion oder maintain
HashTable -> Thread Safe
ConcurrentHashMap -> Thread safe, faster than HashTable

Note : To make the thread safe map we can use as below.
Map<String, String> synchronizedMap = Collections.synchronizedMap(new HashMap<>());

----------------*/

