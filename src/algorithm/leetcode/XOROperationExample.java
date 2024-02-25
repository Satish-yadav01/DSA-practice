package algorithm.leetcode;

public class XOROperationExample {

    public static void main(String[] args) {
        int[] originalArray = {1, 0, 2, 1};
        int xorValue = 1;

        // XOR each element of the original array with xorValue
        int[] resultArray = xorArrayWithConstant(originalArray, xorValue);

        // Print the result array
        for (int num : resultArray) {
            System.out.print(num + " ");
        }
    }

    public static int[] xorArrayWithConstant(int[] array, int xorValue) {
        // XOR each element of the array with xorValue
        int[] resultArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            resultArray[i] = array[i] ^ xorValue;
        }

        return resultArray;
    }
}

