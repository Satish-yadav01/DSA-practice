package algorithm.leetcode.math;

import java.util.HashMap;

public class RomanToInteger {
    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println("result : " + result);
    }

    public static int romanToInt(String s) {

        int answer = 0, number = 0, prev = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            switch (s.charAt(j)) {
                case 'M' -> number = 1000;
                case 'D' -> number = 500;
                case 'C' -> number = 100;
                case 'L' -> number = 50;
                case 'X' -> number = 10;
                case 'V' -> number = 5;
                case 'I' -> number = 1;
            }
            if (number < prev) {
                answer -= number;
            }
            else {
                answer += number;
            }
            prev = number;
        }
        return answer;
    }

    public int romanToInt2(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }

        return ans;
    }
}
