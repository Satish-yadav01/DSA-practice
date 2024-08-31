package algorithm.leetcode.array.hashing;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] transpose = transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.asList(transpose).stream().map(Arrays::toString).collect(Collectors.joining(" ")));

    }

    private static int[][] transpose(int[][] matrix) {
        int [][] matrix2 = new int[matrix[0].length][matrix.length];
        int indexi=0,indexj=0,i=0,j=0;

        int length = matrix[0].length * matrix.length;
        int column = matrix[0].length;
        for(int k=1; k<=length; k++){

//            System.out.println("k : "+k);
//            System.out.println("matrix2["+ indexi +"]["+i+"] : "+ matrix[i][j]);
            matrix2[indexi][i] = matrix[i][j];
            indexi++;
            j++;

            if(k == column ){
                i++;
                j=0;
                indexi=0;
                column = column+matrix[0].length;
            }

        }

        return matrix2;
    }
}
