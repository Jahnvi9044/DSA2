package Graph2;

import java.util.*;

public class Edge  {

    int sv;
    int fv;
    Integer weight;

    public Edge(int sv, int fv, Integer weight) {
        this.sv = sv;
        this.fv = fv;
        this.weight = weight;
    }

    public  String toString(){
        String st=sv+" "+fv+" "+weight;
        return st;
    }

}





