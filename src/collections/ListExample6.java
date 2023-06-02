package collections;

//https://chat.openai.com/c/58eab85c-cf3a-4bbd-b57e-47739e34c654
import java.util.*;

interface question{
    void maxSumSubArray(List<Integer> list);
    void longestSubsequence(List<Integer> list);
    void mergeKSortedList(List<List<Integer>> lists);
}

class Answer implements question {

    //Implement a method that takes a list of integers and returns the maximum sum of any contiguous subarray in the list. For example, given the list [-2, 1, -3, 4, -1, 2, 1, -5, 4], the output should be 6 (which corresponds to the sum of the subarray [4, -1, 2, 1]).
    @Override
    public void maxSumSubArray(List<Integer> list) {
        int maxEnding = 0;
        int maxSoFar = 0;
        for (int i = 0; i < list.size(); i++) {
            maxEnding = Math.max(0, maxEnding + list.get(i));
            maxSoFar = Math.max(maxSoFar, maxEnding);
        }
        System.out.println(maxSoFar);
    }

    //Given a list of integers, implement a method to find the longest increasing subsequence in the list. A subsequence is a sequence that can be derived from the original sequence by deleting some or no elements without changing the order of the remaining elements. For example, given the list [10, 22, 9, 33, 21, 50, 41, 60, 80], the longest increasing subsequence is [10, 22, 33, 50, 60, 80].
    @Override
    public void longestSubsequence(List<Integer> list) {
        int[] dp = new int[list.size()];
        Arrays.fill(dp, 1);
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int maxIndex = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        int currentLength = dp[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (dp[i] == currentLength) {
                result.add(list.get(i));
                currentLength--;
            }
        }
        Collections.reverse(result);
    }

    //Implement a method to merge k sorted lists of integers into a single sorted list. For example, given the following lists [1, 4, 5], [1, 3, 4], [2, 6], the output should be [1, 1, 2, 3, 4, 4, 5, 6].
    @Override
    public void mergeKSortedList(List<List<Integer>> lists) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (List<Integer> list : lists) {
            heap.addAll(list);
        }
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }
    }
}
public class ListExample6{
    public static void main(String[] args) {
        int array[] = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <array.length; i++) {
            list.add(array[i]);
        }
        Answer ans = new Answer();
        ans.maxSumSubArray(list);
    }


}

