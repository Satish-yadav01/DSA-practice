package interviewBasics.hackerEarth;
//Problem
//        Bob has a playlist of
//        songs, each song has a singer associated with it (denoted by an integer)
//
//        Favourite singer of Bob is the one whose songs are the most on the playlist
//
//        Count the number of Favourite Singers of Bob
//
//        Input Format
//
//        The first line contains an integer
//        , denoting the number of songs in Bob's playlist.
//
//        The following input contains
//        integers,
//        integer denoting the singer of the
//        song.
//
//        Output Format
//
//        Output a single integer, the number of favourite singers of Bob
//
//        Note: Use 64 bit data type
//
//        Constraints
//
//
//        Sample Input
//        5
//        1 1 2 2 4
//        Sample Output
//        2
//        Time Limit: 1
//        Memory Limit: 256
//        Source Limit:
//        Explanation
//        In this example
//        Songs of singer 1 and 2 appear 2 times(which is max) in this playlist
//        Therefore the answer is 2
import java.util.*;

public class Favourite_Singer {
    public static void main(String[] args) {
        System.out.println("Enter n:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int array[] = new int[n];
        for(int i=0; i<= array.length-1; i++){
            array[i] = sc.nextInt();
        }

        //logic
        HashMap<Integer, Integer> map = new HashMap<>();
        //array to map
        for (int i = 0; i < array.length; i++) {
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i])+1);
            }
        }
//        System.out.println(map);
        int result=0,max = Integer.MIN_VALUE;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int occurrence = entry.getValue();

            if(occurrence > max || (occurrence == max && num > result)){
                max = occurrence;
                result = num;
            }
        }
        System.out.println(result);
    }
}
