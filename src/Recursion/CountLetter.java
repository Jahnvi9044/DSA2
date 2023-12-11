package Recursion;

import java.util.*;

public class CountLetter {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();

        System.out.println( encode(st));
    }
        public static String encode(String message) {
            // Write your code here.
            return encode(message,1);

        }

        private static String encode(String message,int count) {

            if(message.length()<=1)
            {
                if(count>0)
                {
                    char ch=message.charAt(0);
                    return ch+Integer.toString(count);
                }
                else return "";

            }
            char ch=message.charAt(0);
            char ch2=message.charAt(1);
            if(ch==ch2)
            { count++;
                return ""+encode(message.substring(1),count);
            }
            else return ch+Integer.toString(count)+encode(message.substring(1),1);




        }


    }