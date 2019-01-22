package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 单调递增的数字
 * @date: 2019/01/22
 */
public class Solution738 {

    public static void main(String[] args) {
        final int n = 332;

        System.out.println(new Solution738().monotoneIncreasingDigits(n));
    }

    public int monotoneIncreasingDigits(int N) {
        char[] number = String.valueOf(N).toCharArray();

        // 必须从后向前推导,才能确保最前面几个数字是递增的
        int mark = number.length;
        for (int i = number.length - 1; i > 0; --i) {
            if (number[i] < number[i - 1]) {
                mark = i - 1;
                --number[mark];
            }
        }

        for (int i = mark + 1; i < number.length; ++i) {
            number[i] = '9';
        }

        return Integer.parseInt(new String(number));
    }

}
