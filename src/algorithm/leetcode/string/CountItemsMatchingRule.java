package algorithm.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountItemsMatchingRule {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("phone", "blue", "pixel"));
        items.add(Arrays.asList("computer", "silver", "phone"));
        items.add(Arrays.asList("phone", "gold", "iphone"));
        items.add(Arrays.asList("computer", "silver", "phone"));

        int count = countMatches(items, "color", "silver");
        System.out.println("count: "+count);


        char[] result = {'a','b','c','d'};
        String s = String.copyValueOf(result);
        System.out.println(s);
    }

    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        int count=0;

        for(int i=0; i<= items.size()-1; i++){
            if(ruleKey.equals("type")){
                if(ruleValue == items.get(i).get(0)){
                    count++;
                    // continue;
                }
            }

            if(ruleKey.equals("color")){
                if(ruleValue == items.get(i).get(1)){
                    System.out.println(items.get(i).get(1));
                    count++;
                    // continue;
                }
            }

            if(ruleKey.equals("name")){
                if(ruleValue == items.get(i).get(2)){
                    count++;
                    // continue;
                }
            }
        }

        return count;

    }
}
