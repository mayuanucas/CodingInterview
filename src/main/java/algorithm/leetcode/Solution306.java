package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 累加数
 * @date: 2018/08/13
 */
public class Solution306 {
    public static void main(String[] args) {
        Solution306 test = new Solution306();

        String str = "11235813213455890144";
        System.out.println(test.isAdditiveNumber(str));
    }

    public boolean isAdditiveNumber(String num) {
        int length = num.length();

        if (length < 3) {
            return false;
        }

        for (int i = 1; i <= length / 2; ++i) {
            for (int j = 1; Math.max(i, j) <= length - i - j; ++j) {
                if (isValid(num, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(String num, int i, int j) {
        if (num.charAt(0) == '0' && 1 < i) {
            return false;
        }
        if (num.charAt(i) == '0' && 1 < j) {
            return false;
        }

        String sum = null;
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x1 + x2;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) {
                return false;
            }
        }
        return true;
    }
}
