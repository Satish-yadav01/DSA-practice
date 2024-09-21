package algorithm.leetcode.statck;

/*
* Minimum Stack
Solved
Design a stack class that supports the push, pop, top, and getMin operations.

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
Each function should run in
O
(
1
)
O(1) time.

Example 1:

Input: ["MinStack", "push", 1, "push", 2, "push", 0, "getMin", "pop", "top", "getMin"]

Output: [null,null,null,null,0,null,2,1]

Explanation:
MinStack minStack = new MinStack();
minStack.push(1);
minStack.push(2);
minStack.push(0);
minStack.getMin(); // return 0
minStack.pop();
minStack.top();    // return 2
minStack.getMin(); // return 1
Constraints:

-2^31 <= val <= 2^31 - 1.
pop, top and getMin will always be called on non-empty stacks.
*
* */


import java.util.ArrayList;
import java.util.List;

public class MinimumStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
    }

    static class MinStack {
        List<int[]> list=null;

        public MinStack() {
            list = new ArrayList<>();
        }

        public void push(int val) {
            int[] top = list.isEmpty() ? new int[]{val,val} : list.get(list.size()-1);
            int minVal = top[1];
            if(minVal  > val){
                minVal = val;
            }

            list.add(new int[]{val,minVal});
        }

        public void pop() {
            list.remove(list.size()-1);
        }

        public int top() {
            return list.isEmpty() ? -1 : list.get(list.size() - 1)[0];
        }

        public int getMin() {
            return list.isEmpty() ? -1 : list.get(list.size() - 1)[1];
        }
    }

}
