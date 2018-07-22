package my.learn;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/22
 */
public class MyTreeMap {

    public static void main(String[] args) {
        Map<Integer, String> map1 = new TreeMap<>();

        map1.put(9, "jiu");
        map1.put(19, "shijiu");
        map1.put(1, "yi");
        map1.put(0, "zero");

        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getKey());
        }
        System.out.println("************************");

        Map<Integer, String> map2 = new TreeMap<>(Comparator.reverseOrder());

        map2.put(9, "jiu");
        map2.put(19, "shijiu");
        map2.put(1, "yi");
        map2.put(0, "zero");
        for (Map.Entry<Integer, String> entry : map2.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getKey());
        }
        System.out.println("************************");


    }
}
