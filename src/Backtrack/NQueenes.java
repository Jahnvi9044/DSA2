package Backtrack;

import java.util.*;

public class NQueenes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            int n = sc.nextInt();
            int board[][] = new int[n][n];
            placeQueens(n,0,board);
        }

    }


    private static void placeQueens(int n, int row,int[][] board) {
        if(row == n) {

            for(int r=0;r<n;r++)
            {
                for(int c=0;c<n;c++)
                {
                    System.out.print(board[r][c]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
// valid board configuration
        }

            for(int j=0;j<n;j++)
            {
                if(isSafe(row,j,board)  &&  board[row][j]!=1)
                {     board[row][j]=1;
                     placeQueens(n,row+1,board);
                     board[row][j]=0;}
            }


// check for all columns
// check if its safe to place Queen
// if it’s safe -> then place the queen and move to next row
    }

    public static boolean isSafe(int i,int j,int[][] board)
    {
        for(int k=0;k< board.length;k++)
        {
            if(board[k][j]==1||board[i][k]==1)
                return false;
        }

        for(int k=0; k< board.length; k++)
        {
            for(int l=0;l< board.length;l++) {
                if (l+k==i+j || k-l==i-j)
                    if(board[k][l]==1)
                       return false;
            }
        }
        return true;

    }
}




