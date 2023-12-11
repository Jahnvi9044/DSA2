package Map;

import java.util.*;

public class MapNode<T,V> {
    T key;
    V value;
    MapNode<T,V> next;
    MapNode( T key, V value)
    {
        this.key=key;
        this .value=value;

    }

}
