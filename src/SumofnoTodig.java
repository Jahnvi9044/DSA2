import java.util.*;

public class SumofnoTodig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {//Write your code here
            int n = 478595  ;
            System.out.println(digSum(n));

        }

    }




        static int digSum(int n)
        {
            if (n == 0)
                return 0;
            return (n % 9 == 0) ? 9 : (n % 9);
        }

        // Driver program to test the above function

    }



