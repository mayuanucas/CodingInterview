package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/17
 */
public class Solution633 {
    public static void main(String[] args) {
        Solution633 test = new Solution633();

        System.out.println(test.judgeSquareSum(100000));
    }

    public boolean judgeSquareSum(int c) {
        if (0 > c) {
            return false;
        }

        int left = 0;
        int right = (int) Math.sqrt(c);
        while (left <= right) {
            int temp = left * left + right * right;
            if (temp < c) {
                ++left;
            } else if (temp > c) {
                --right;
            } else {
                return true;
            }
        }
        return false;
    }
}
