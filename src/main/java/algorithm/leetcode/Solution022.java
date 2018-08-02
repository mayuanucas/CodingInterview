package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/16
 */
public class Solution022 {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans, "", n, 0, 0);
        return ans;
    }

    public void dfs(List<String> ans, String temp, int n, int left, int right) {
        if (right == n) {
            ans.add(temp);
            return;
        }

        if (left < n) {
            dfs(ans, temp + "(", n, left + 1, right);
        }
        if (right < left) {
            dfs(ans, temp + ")", n, left, right + 1);
        }
    }
}
