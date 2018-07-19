package my.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/19
 */
public class MyHashMap {

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>(32);

        map1.put("a", "优秀");
        map1.put("b", "良好");
        map1.put("c", "及格");
        map1.put("d", "差");
        map1.put("e", "极差");

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

    }

}
