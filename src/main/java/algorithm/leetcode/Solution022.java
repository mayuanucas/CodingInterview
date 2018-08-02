package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/16
 */
public class Solution022 {

    public static void main(String[] args) {
        System.out.println(new Solution022().generateParenthesis(3));
    }

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

        // 左括号数量少于 n ,优先添加左括号
        if (left < n) {
            dfs(ans, temp + "(", n, left + 1, right);
        }
        // 右括号数量少于左括号数量 ,添加右括号与左括号配对
        if (right < left) {
            dfs(ans, temp + ")", n, left, right + 1);
        }
    }
}
