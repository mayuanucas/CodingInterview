package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/21
 */
public class Solution241 {
    public static void main(String[] args) {
        String str1 = "2*3-4*5";

        Solution241 test = new Solution241();
        List<Integer> ans = test.diffWaysToCompute(str1);
        ans.forEach(System.out::println);
    }

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            char c = input.charAt(i);
            if ('+' == c || '-' == c || '*' == c) {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        switch (c) {
                            case '+': {
                                ways.add(l + r);
                                break;
                            }
                            case '-': {
                                ways.add(l - r);
                                break;
                            }
                            case '*': {
                                ways.add(l * r);
                                break;
                            }
                            default: {
                                continue;
                            }
                        }
                    }
                }
            }
        }

        if (ways.size() == 0) {
            ways.add(Integer.valueOf(input));
        }
        return ways;
    }
}
