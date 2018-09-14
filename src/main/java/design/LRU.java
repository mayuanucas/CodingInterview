package design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc: LRU算法的实现
 * @date: 2018/09/14
 */
public class LRU<K, V> {

    private static final float loadFactor = 0.75F;
    private LinkedHashMap<K, V> map;
    private final int capacity;

    public LRU(int size) {
        this.capacity = size;
        int cap = (int) Math.ceil(size / loadFactor) + 1;

        map = new LinkedHashMap<K, V>(cap, loadFactor, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > capacity;
            }
        };
    }

    public V get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {
        map.put(key, value);
    }
}
