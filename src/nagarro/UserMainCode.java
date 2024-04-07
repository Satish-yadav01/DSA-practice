package nagarro;

import java.util.*;

class UserMainCode {

    public static void main(String[] args) {
        int input1=3;
        int input2=5;
        int [][]input3 = {
                {75,76,65,87,87},
                {78,76,68,56,89},
                {67,87,78,77,65}
        };
        int[] ints = calculateTotalMarks(input1, input2, input3);
        Arrays.stream(ints).forEach(e-> System.out.println(e+" "));

    }

    public static int[] calculateTotalMarks(int input1, int input2, int[][] input3) {
        int[] res = new int[input1]; // array to store total marks for each student

        // Calculate total marks for each student excluding the lowest average subject
        for (int i = 0; i < input1; i++) {
            int minAvgSubjectIndex = getMinAvgSubjectIndex(input2, input3);
            int sum = 0;
            for (int j = 0; j < input2; j++) {
                if (j != minAvgSubjectIndex) {
                    sum += input3[i][j];
                }
            }
            res[i] = sum;
        }
        return res;
    }

    // Helper function to get the index of the subject with the lowest average marks
    private static int getMinAvgSubjectIndex(int numSubjects, int[][] marks) {
        double[] avgMarks = new double[numSubjects];
        Arrays.fill(avgMarks, 0);

        // Calculate average marks for each subject
        for (int j = 0; j < numSubjects; j++) {
            double sum = 0;
            for (int i = 0; i < marks.length; i++) {
                sum += marks[i][j];
            }
            avgMarks[j] = sum / marks.length;
        }

        // Find the index of the subject with the lowest average marks
        int minIndex = 0;
        for (int i = 1; i < numSubjects; i++) {
            if (avgMarks[i] < avgMarks[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}