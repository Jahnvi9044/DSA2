package Backtrack;
/*
Code: Rat In a Maze All Paths
Send Feedback
You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.
Input Format
The first line of input contains an integer 'N' representing
the dimension of the maze.
The next N lines of input contain N space-separated
integers representing the type of the cell.
Output Format :
For each test case, print the path from start position to destination position and only cells that are part of the solution path should be 1, rest all cells should be 0.

Output for every test case will be printed in a separate line.
Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec
Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1
Sample Output 1 Explanation :
Only 1 path is possible

1 0 0
1 0 0
1 1 1
Which is printed from left to right and then top to bottom in one line.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1
1 0 0 1 0 0 1 1 1
1 0 0 1 1 0 0 1 1
1 0 0 1 1 1 0 0 1
Sample Output 2 Explanation :
4 paths are possible which are printed in the required format.
 */
import java.util.*;

public class RatInAMaze {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1--> open
        // 0--> closed
        int[][] maze={{1 , 0, 1},
                      {1 , 1, 1},
                      {0 , 1 ,1}};
        int[][] path=new int[3][3];
        if(ratsmove(maze,path,0,0,3))
            for(int i=0;i<maze.length;i++)
                for(int j=0;j<maze.length;j++) {
                    if(path[i][j]==1)
                    {
                    if(i==maze.length-1&&j==maze.length-1)
                        System.out.println("(" + i + " " + j + ")" );
                    else
                    System.out.print("(" + i + " " + j + ")" + "-->");
                }}
        else System.out.println("false");



    }

    public static boolean  ratsmove(int [][] maze,int[][]path,int i,int j,int n)
    {
        //baseCase
       //First check it is valid or not
      if(i<0||j>n-1||i>n-1||j<0||path[i][j]==1||maze[i][j]==0)
          return false ;
       //Now the cell is valid
       //if true then it will come here
        //Add it to the path
       path[i][j]=1;

       //Check if it is destination
        if(i==n-1 && j==n-1) {
            for(int r=0;r<n;r++)
            {
                for(int c=0;c<n;c++)
                    System.out.print(path[r][c]+" ");

            }
            System.out.println();
            path[i][j]=0;
            return true;
        }

         //Check Right cell
         ratsmove(maze, path,i,j+1,n);

         //Check Down  cell
         ratsmove(maze,path,i+1,j,n);

         //Check Left cell
         ratsmove(maze,path,i,j-1,n);

        //Check Top cell
        ratsmove(maze,path,i-1,j,n);
        path[i][j]=0;


         return false ;
    }
}
