package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/18
 */
public class Solution455 {
    public static void main(String[] args) {
        int[] g = {1, 2};
        int[] s = {1, 2, 3};

        Solution455 test = new Solution455();
        System.out.println(test.findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gIndex = 0, sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            if (g[gIndex] <= s[sIndex]) {
                ++gIndex;
            }
            ++sIndex;
        }
        return gIndex;
    }
}
