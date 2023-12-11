import java.util.*;

class sum {



    public static void main(String[] args)
    {    Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                arr[i]=arr[i]*(int)Math.pow(2,i);
            }
            int temp=0;
            int p=0,q=0;
            for (int i = 0; i < n; i++) {
                temp = 0;

                for (int j = i; j < n; j++) {

                    System.out.println();

                for(int k=j;k<n;k++) {
                    temp += arr[k];
                    System.out.print(arr[k]+" ");
                }}

                if(temp>0)
                    p++;
                if(temp<0)
                    q++;
            }




        }}}
