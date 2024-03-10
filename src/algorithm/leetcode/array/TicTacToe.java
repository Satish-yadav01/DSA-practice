package algorithm.leetcode.array;

public class TicTacToe {
    public static void main(String[] args) {
        String tictactoe = tictactoe(new int[][]{{0, 0}, {2, 0}, {1, 1}, {2, 1}, {2, 2}});
        System.out.println("output : " + tictactoe);
    }

    public static String tictactoe(int[][] moves) {
        if (moves == null || moves.length > 9) {
            throw new IllegalArgumentException("Input move list is invalid");
        }

        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int diag1 = 0;
        int diag2 = 0;
        int numMoves = moves.length;

        for (int i = 0; i < numMoves; i++) {
            int r = moves[i][0];
            int c = moves[i][1];
            int val = i % 2 == 0 ? 1 : -1;
            rows[r] += val;
            cols[c] += val;
            if (r == c) {
                diag1 += val;
            }
            if (r + c == n - 1) {
                diag2 += val;
            }
//            System.out.println("Math.abs(rows[r])  :"+ Math.abs(rows[r]) );
            if (Math.abs(rows[r]) == n || Math.abs(cols[c]) == n || Math.abs(diag1) == n || Math.abs(diag2) == n) {
                if (i != numMoves - 1) {
                    throw new IllegalArgumentException("Input move list is invalid");
                }
                return val == 1 ? "A" : "B";
            }
        }

        return numMoves == 9 ? "Draw" : "Pending";
    }
}
