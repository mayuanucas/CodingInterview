package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 将数组拆分成斐波那契序列
 * @date: 2019/02/01
 */
public class Solution842 {

    public static void main(String[] args) {
        String str = "0123";
        for (int e : new Solution842().splitIntoFibonacci(str)) {
            System.out.print(e + " ");
        }
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> answer = new ArrayList<>(S.length() / 2);
        dfs(answer, S, 0);
        return answer;
    }

    public boolean dfs(List<Integer> answer, String str, int start) {
        if (start == str.length() && 3 <= answer.size()) {
            return true;
        }

        for (int i = start; i < str.length(); ++i) {
            if ('0' == str.charAt(start) && i > start) {
                break;
            }
            long num = Long.parseLong(str.substring(start, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }

            int size = answer.size();
            if (2 <= size && num > answer.get(size - 1) + answer.get(size - 2)) {
                break;
            }
            if (1 >= size || num == answer.get(size - 1) + answer.get(size - 2)) {
                answer.add((int) num);
                // 如果已经找到一组符合要求的解,则直接返回(不再从列表中删除元素)
                // 否则再移除列表中最后一个元素,继续回溯
                if (dfs(answer, str, i + 1)) {
                    return true;
                } else {
                    answer.remove(answer.size() - 1);
                }
            }
        }
        return false;
    }

}
