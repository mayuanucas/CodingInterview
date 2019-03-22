package algorithm.note;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc: LRU算法的实现
 * @date: 2018/09/14
 */
public class LRU<K> {

    private static final float loadFactor = 0.75F;
    private final int capacity;

    private LinkedHashMap<K, K> map;

    public LRU(int size) {
        this.capacity = size;
        int cap = (int) Math.ceil(size / loadFactor) + 1;

        map = new LinkedHashMap<K, K>(cap, loadFactor, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry entry) {
                return size() > capacity;
            }
        };
    }

    public K get(K key) {
        return map.get(key);
    }

    public void put(K key) {
        map.put(key, key);
    }
}
