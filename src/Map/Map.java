package Map;

import java.util.*;

public class Map<K,V> {
     ArrayList<MapNode<K,V>> buckets ;
      int numBucket;
      int size;

      Map()
      {
          buckets=new ArrayList<>();
          size=20;
          for(int i=0;i<20;i++)
          {
              buckets.add(null);
          }

       }
       private int getBucketIndex(K key)
       { int HashCode=key.hashCode();
           return HashCode%numBucket;

       }

       public void insert(K key, V value)
       {

       }
}
