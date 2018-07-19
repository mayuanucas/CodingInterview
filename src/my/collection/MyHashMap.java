package my.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/19
 */
public class MyHashMap {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>(4);

        map1.put("aa", "优秀");
        map1.put("ab", "良好");
        map1.put("cb", "及格");
        map1.put("db", "差");
        map1.put("ea", "极差");

        // map 的遍历
        // 1. jdk1.8
        map1.forEach((k, v) -> {
            System.out.println("key=" + k + ", value=" + v);
        });
        System.out.println("********************************");
        // 2.
        for (Map.Entry entry : map1.entrySet()) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }
        System.out.println("********************************");


        // 有序 hash
        Map<String, String> map2 = new LinkedHashMap<>();
        map2.put("za", "优秀");
        map2.put("bz", "良好");
        map2.put("cz", "及格");
        map2.put("zd", "差");
        map2.put("ez", "极差");

        for (Map.Entry entry : map2.entrySet()) {
            System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());
        }
        System.out.println("********************************");



    }

}
