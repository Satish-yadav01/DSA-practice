package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author satish-yadav <satishyadav.ssy02@gmail.com>
 * @apiNote  You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
 *
 *
 *  Example 1:
 *
 * Input: people = [1,2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 * Example 2:
 *
 * Input: people = [3,2,2,1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 *
 * @version 1.0
 *
 * @see <a href="https://leetcode.com/submissions/detail/1248806530/">link</a>
 *
 *
 */
public class BoatsToSavePeople {
    public static void main(String[] args) {
        int boats = numRescueBoats(new int[]{3,3,2,1,1,2,3,2,2,1}, 3);
        System.out.println("boats : "+ boats);
    }

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int i=0, j=people.length-1;
        while(i<=j){
            if(people[i] + people[j] <= limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}
