package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 计算各个位数不同的数字个数
 * @date: 2019/02/16
 */
public class Solution357 {

    public int countNumbersWithUniqueDigits(int n) {
        int[] f = new int[11];
        f[0] = 1;
        f[1] = 10;
        f[2] = 81;

        for (int i = 3, num = 8; i < f.length; ++i) {
            f[i] = f[i - 1] * num;
            if (1 < num) {
                --num;
            }
        }
        for (int i = 2; i < f.length; ++i) {
            f[i] += f[i - 1];
        }

        return 11 > n ? f[n] : f[10];
    }
}
