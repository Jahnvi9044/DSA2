
import java.math.BigInteger;
import java.util.*;

public class Codechef1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] A=new int[r][c];
        int[][] B=new int[r][c];
        int[][] ans=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {   A[i][j]=sc.nextInt();

            }
        }

        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {   B[i][j]=sc.nextInt();

            }
        }
        sumM(A,B,ans,0,0,r,c);
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                System.out.print(ans[i][j]+" ");

            }
            System.out.println();
        }
    }

    public static void sumM(int[][] A, int[][] B,int[][] ans,int i,int j,int r,int c)
    {

        if(i>=r )
            return;


        if(j>=c) {


            sumM(A, B, ans, i + 1, 0, r, c);
        }

        else {
            ans[i][j]=A[i][j]+B[i][j];

            sumM(A, B, ans, i, j + 1, r, c);

        }

    }
}
