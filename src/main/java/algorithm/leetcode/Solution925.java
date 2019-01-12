package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 长按键入
 * @date: 2019/01/12
 */
public class Solution925 {

    public boolean isLongPressedName(String name, String typed) {
        if (null == name || null == typed) {
            return false;
        }

        int i = 0;
        for (int j = 0; j < typed.length(); ++j) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                ++i;
            } else if (0 == j || typed.charAt(j - 1) != typed.charAt(j)) {
                return false;
            }
        }
        return i == name.length();
    }

}
