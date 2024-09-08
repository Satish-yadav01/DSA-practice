package interviewBasics.hackerEarth;

/*
Problem
You are given a table with
 rows and
 columns. Each cell is colored with white or black. Considering the shapes created by black cells, what is the maximum border of these shapes? Border of a shape means the maximum number of consecutive black cells in any row or column without any white cell in between.

A shape is a set of connected cells. Two cells are connected if they share an edge. Note that no shape has a hole in it.

Input format

The first line contains
 denoting the number of test cases.
The first line of each test case contains integers
 denoting the number of rows and columns of the matrix. Here, '#' represents a black cell and '.' represents a white cell.
Each of the next
 lines contains
 integers.
Output format

Print the maximum border of the shapes.

Sample Input
10
2 15
.....####......
.....#.........
7 9
...###...
...###...
..#......
.####....
..#......
...#####.
.........
18 11
.#########.
########...
.........#.
####.......
.....#####.
.....##....
....#####..
.....####..
..###......
......#....
....#####..
...####....
##.........
#####......
....#####..
....##.....
.#######...
.#.........
1 15
.....######....
5 11
..#####....
.#######...
......#....
....#####..
...#####...
8 13
.....######..
......##.....
########.....
...#.........
.............
#######......
..######.....
####.........
7 5
.....
..##.
###..
..##.
.....
..#..
.#...
14 2
..
#.
..
#.
..
#.
..
..
#.
..
..
..
#.
..
7 15
.###########...
##############.
...####........
...##########..
.......#.......
.....#########.
.#######.......
12 6
#####.
###...
#.....
##....
###...
......
.##...
..##..
...#..
..#...
#####.
####..
Sample Output
4
5
9
6
7
8
3
1
14
5
Time Limit: 1
Memory Limit: 256
Source Limit:


 */



import java.util.Scanner;

public class MaximumBorder {
    public static void main(String[] args) {
        // Write your code here
        System.out.println("enter test case:");
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int l=0; l<=t-1; l++){
            System.out.println("enter n:");
            int n = sc.nextInt();
            System.out.println("enter m:");
            int m = sc.nextInt();

            char a[][] = new char[n][m];
            System.out.println("enter values in array");
            for(int i=0; i<=n-1; i++){
                for(int j=0; j<=m-1; j++){

                    a[i][j] = sc.next().charAt(0);

                }
            }

            int maxBlackCell = toFindMaxBlackCell(a,n,m);
            System.out.println(maxBlackCell);
        }
    }

    public static int toFindMaxBlackCell(char a[][],int n,int m){
        int maxBlackCell = 0;
        int count = 0;
        for(int i=0; i<=n-1; i++){
            count = 0;
            for(int j=0; j<=m-1; j++){
                if(a[i][j] == '#'){
                    count++;
                }
            }
            if(maxBlackCell < count){
                maxBlackCell = count;
            }

        }
        return 0;
    }

}
