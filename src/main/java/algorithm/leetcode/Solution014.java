package algorithm.leetcode;

/**
 * @author mayuan
 * @desc
 * @date 2018/02/08
 */
public class Solution014 {

    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }

        String pre = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }

        return pre;
    }

}
