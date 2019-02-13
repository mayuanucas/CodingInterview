package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 第k个排列
 * @date: 2018/08/03
 */
public class Solution060 {

    public static void main(String[] args) {
        Solution060 test = new Solution060();
        System.out.println(test.getPermutation(4, 9));
    }

    /**
     * 在n!个排列中，第一位的元素总是(n-1)!一组出现的，也就说如果a = (k-1) / (n-1)!，那么排列的最开始一个元素一定是numbers[a]
     * k1 = k
     * a1 = (k1-1) / (n-1)!     number[a1]
     * k2 = k1 - a1 * (n-1)!
     * a2 = (k2-1) / (n-2)!     number[a1]
     *
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        // 存储阶乘的数组
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; ++i) {
            factorial[i] = i * factorial[i - 1];
        }

        // k 越界
        if (k > factorial[n]) {
            return "";
        }

        List<Integer> numbers = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        // 可以认为是:依次确定从左边第1位到右边第n位数字的过程
        for (int i = 1; i <= n; i++) {
            int a = (k - 1) / factorial[n - i];
            stringBuilder.append(numbers.get(a));
            // 添加该数字后,需要从列表中把该数字删除
            numbers.remove(a);
            // 此处不用取余,避免K为-1
            k -= a * factorial[n - i];
        }
        return stringBuilder.toString();
    }


}
