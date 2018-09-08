package algorithm.str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: mayuan
 * @desc: 第一个只出现一次的字符
 * @date: 2018/09/08
 */
public class Problem07 {
    public static void main(String[] args) {
        String str = "abcabb";

        int ans = FirstNotRepeatingChar(str);
        System.out.println((char)ans);
    }

    public static int FirstNotRepeatingChar(String str) {
        if (null == str || str.length() < 1) {
            return -1;
        }

        Map<Character, Integer> map = new HashMap<>(128);
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str.toCharArray()) {
            if (1 == map.getOrDefault(c, 0)) {
                return c;
            }
        }
        return -1;
    }
}
