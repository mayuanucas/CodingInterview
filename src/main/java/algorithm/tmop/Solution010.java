package algorithm.tmop;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 寻找和为定值的多个数
 * 时间复杂度: O(n!)
 * 空间复杂度:
 * @date:
 */
public class Solution010 {

    public static void main(String[] args) {
        sumOfKNumber(10, 10, new LinkedList<>());
    }

    /**
     * n 问题转化为 n-1 问题
     * 1.如果取第 n 个数,则问题转化为取前 n-1 个数使得它们的和为 sum-n
     * 2.如果不取第 n 个数,则问题转化为取前 n-1 个数使得它们的和为 sum
     *
     * @param sum
     * @param n
     * @param answer
     */
    public static void sumOfKNumber(int sum, int n, List<Integer> answer) {
        if (0 >= sum || 0 >= n) {
            return;
        }

        // 找到一组解,直接输出
        if (sum == n) {
            for (Integer num : answer) {
                System.out.print(num + " ");
            }
            System.out.println(n);
        }

        answer.add(n);
        sumOfKNumber(sum - n, n - 1, answer);
        answer.remove(answer.size() - 1);
        sumOfKNumber(sum, n - 1, answer);
    }
}
