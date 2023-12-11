package Map;

import java.util.*;

public class MapUse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<Integer,Boolean> map=new HashMap<>();
        ArrayList<Integer> ar=new ArrayList<>();
        int n=sc.nextInt();
        int[] arr=new int[n];
        for( int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], true);
                ar.add(arr[i]);
            }


        }
        Set<Integer> keys=map.keySet();
        for(int i:keys)
            System.out.print(i+" ");
        System.out.println();
        System.out.println(map);
        System.out.println(ar);
    }
}
