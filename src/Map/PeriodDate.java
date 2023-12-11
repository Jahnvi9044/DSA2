package Map;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class PeriodDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Temporal temp=;
//        OffsetDateTime of=OffsetDateTime.now();
//        OffsetDateTime of2=of.plusDays(28L);
//        int day=of2.getDayOfMonth();
//        int month=of2.getMonthValue();
//        int year=of2.getYear();
//
//        System.out.println(of2);
//        System.out.println(day+":"+month+":"+year);
//        int min=of2.getMinute();
//        int hrs=of2.getHour();
//        int sec=of2.getSecond();
        System.out.println("Enter date in YYYY-MM-DD format");
         String st=sc.nextLine();
        LocalDate date=LocalDate.parse(st);
        LocalDate newDate=date.plusDays(28);
        System.out.println(newDate);
        DayOfWeek day=newDate.getDayOfWeek();
        System.out.print(day+",");
        System.out.println(newDate.getMonth()+" "+newDate.getYear());
        System.out.println("To check if your periods are clashing ,Enter chk  else press enter");
        String s=sc.nextLine();
        if(!s.equals("chk"))
            return;
        System.out.println("Enter the date in YYYY-MM-DD format");
        String st2=sc.nextLine();
        LocalDate date1=LocalDate.parse(st2);
        LocalDate dd=date;
        for(int i=0;i<12;i++)
        {  dd = dd.plusDays(28);
          LocalDate d2=dd.plusDays(1);
          LocalDate d3=dd.plusDays(2);
          LocalDate d4=dd.plusDays(3);
          LocalDate d5=dd.plusDays(4);


          if(dd.isEqual(date1)||d2.isEqual(date1)||d3.isEqual(date1)||d4.isEqual(date1)||d5.isEqual(date1))
          {
              System.out.println("Ooopsi it is clashing ");
              return ;
          }

        }
        System.out.println("Don't worry every thing is fine ");





    }
}
