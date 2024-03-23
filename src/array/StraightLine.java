package array;

public class StraightLine {
    public static void main(String[] args) {
        boolean straightLine = isStraightLine(new int[][]{{0,0},{0,1},{0,-1}});

        System.out.println("is a straight line : " + straightLine);
    }

    public static boolean isStraightLine(int[][] coordinates){
        int x0 = coordinates[0][0], y0 = coordinates[0][1],
                x1 = coordinates[1][0], y1 = coordinates[1][1];
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] co : coordinates) {
            int x = co[0], y = co[1];
            if (dx * (y - y1) != dy * (x - x1))
                return false;
        }
        return true;
    }
}
