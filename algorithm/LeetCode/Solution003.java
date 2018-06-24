import java.util.*;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/24
 */
public class Solution003 {

    /**
     * 使用滑动窗口方式解题
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int sLength = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(sLength);
        for (int j = 0, i = 0; j < sLength; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)));
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
