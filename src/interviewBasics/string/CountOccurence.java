package interviewBasics.string;

import java.util.Arrays;

public class CountOccurence {
    public static int countOccurence(String s,String k){
        String[] newString = s.toLowerCase().split(" |,");
        Arrays.stream(newString).toList().forEach(i-> System.out.print(i+" "));
        System.out.println();
        int count=0;
        for (String element: newString) {
            if(element.equals(k.toLowerCase())){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "this is Satish, satish is a good programer, satish has developed some skills, SATISH has learned linux and sql,SaTish was good enough";
        String k = "satish";
        int count = countOccurence(s,k);
        System.out.println(k+ "-- is occured "+count+" no of times on below statement\n"+s);
    }
}
