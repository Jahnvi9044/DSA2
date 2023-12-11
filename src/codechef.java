import java.util.*;

public class codechef {
    /* package codechef; // don't place package name! */


        public static void main (String[] args) throws java.lang.Exception
        {
            // your code goes here



            Scanner sc=new Scanner(System.in);
            int t=sc.nextInt();
            while(t-->0)
            {  HashMap<Integer,Integer> map =new HashMap<>();
                int n=sc.nextInt();
                int[] arr=new int[n];
                for(int i=0;i<n;i++)
                    arr[i]=sc.nextInt();

                for(int i=0;i<n;i++)
                {
                    if(map.containsKey(arr[i]))
                    {
                        int k=map.get(arr[i]);
                        k++;
                        map.put(arr[i],k);

                    }

                    else map.put(arr[i],1);
                }


                int n1=map.size();
                int[] a=new int[n1];
                int i=0;
                for(int s:map.keySet())
                {
                    a[i]= map.get(s);
                    i++;


                }
//                System.out.println(map);
                int ans=0;

//                for(int j=0;j<n1;j++)
//                {
//                    System.out.println(a[j]);
//                }

                for(int j=0;j<n1-1;j++)
                {
                    for(int k=j+1;k<n1;k++)
                    {

                        ans+=a[k]*a[j];
                    }
                }
                System.out.println(ans);

            }
        }


    }
