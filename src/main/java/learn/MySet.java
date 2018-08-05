package learn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/05
 */
public class MySet {
    public static void main(String[] args) {
        Set<String> a = new HashSet<>(4);
        a.add("a");
        a.add("b");
        a.add("c");
        a.add("d");
        System.out.println("a:" + a);

        Set<String> b = new HashSet<>(4);
        b.add("aa");
        b.add("b");
        b.add("c");
        b.add("dd");
        System.out.println("b:" + b);

        Set<String> result = new HashSet<>();
        // 集合与集合的交集
        result.clear();
        result.addAll(a);
        result.retainAll(b);
        System.out.println("交集:" + result);

        // 集合与集合的并集
        result.clear();
        result.addAll(a);
        result.addAll(b);
        System.out.println("并集:" + result);

        // 集合与集合的差集
        result.clear();
        result.addAll(a);
        result.removeAll(b);
        System.out.println("差集: a-b " + result);

        result.clear();
        result.addAll(b);
        result.removeAll(a);
        System.out.println("差集: b-a " + result);
    }
}
