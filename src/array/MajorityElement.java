package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int a[] = {1,1,2,2,3,3,3,4};

//        System.out.println(findMaxElementOne(a)); O(n2,1)
//        System.out.println(findMaxElementTwo(a)); //O(nlogn,1)
        System.out.println(findMaxElementThree(a));
    }

    private static int findMaxElementThree(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(!map.containsKey(a[i])){
                map.put(a[i],1);
            }else{
                map.put(a[i],map.get(a[i])+1);
            }
            Map.Entry<Integer, Integer> max = maxElement(map);
            System.out.println(max);
        }
        return 0;
    }

    private static Map.Entry<Integer, Integer> maxElement(HashMap<Integer, Integer> map) {
        Map.Entry<Integer,Integer> maxElement = null;


        for(Map.Entry<Integer,Integer> element:map.entrySet())
        {
            if (maxElement == null || element.getValue().compareTo(maxElement.getValue()) > 0)
            {
                maxElement = element;
            }
        }
        return maxElement;

    }

    //    O(nlogn,1)
    private static int findMaxElementTwo(int[] a) {
        int maxElement=0,maxCount=0,count=0;
        Arrays.sort(a);
        for (int i = 0; i < a.length-1; i++) {
            if(a[i]==a[i+1] ){
                count+=1;
            }else {
                count=0;
            }

            if(maxCount<=count){
                maxElement = a[i];
                maxCount = count;
            }

        }
        return maxElement;
    }

    //O(n2,1)
    private static int findMaxElementOne(int[] a) {
        int max = 0,count=0;
        for (int i = 0; i < a.length; i++) {
            for (int j=0;j<a.length;j++){
                if(a[i]==a[j]){
                    count+=1;
                }
            }
            if(max < count){
                max = a[i];
                count=0;
            }
        }
        return max;
    }

}
