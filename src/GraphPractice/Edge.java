package GraphPractice;

import java.util.*;

public class Edge {
     int source;
     int dest;
     int weight;
   public Edge(int source,int dest, int weight)
   {
      this.source=source;
      this.dest=dest;
      this.weight=weight;

   }

   public void EdgePrint()
   {
      System.out.println(this.source+" "+this.dest+" "+this.weight);

   }
}
