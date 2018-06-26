import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/07
 */
public class Solution008 {

    /**
     * 字符串转整数 最佳方法
     * @param str
     * @return
     */
    public static int myAtoi2(String str) {
        str = str.trim();
        int len = str.length();
        int sign = 1, sum = 0;

        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (i == 0 && (ch == '+' || ch == '-')) {
                sign = (ch == '+') ? 1 : -1;
            } else if (ch >= '0' && ch <= '9') {
                int temp = sum * 10 + (ch - '0') * sign;
                if (temp / 10 != sum) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                sum = temp;
            } else {
                return sum;
            }
        }

        return sum;
    }

    public int myAtoi(String str) {
        if (0 >= str.length()) {
            return 0;
        }

        StringBuilder stringBuilder = new StringBuilder("0");
        int isNeg = 1;
        String newStr = str.trim().split("\\s+")[0];
        if (newStr.length() < 1) {
            return 0;
        }
        char[] nums = newStr.toCharArray();

        int i = 0;
        if ('-' == nums[0]) {
            isNeg = -1;
            i = 1;
        } else if ('+' == nums[0]) {
            isNeg = 1;
            i = 1;
        } else if ('0' > nums[0] || '9' < nums[0]) {
            return 0;
        }

        boolean hasDot = false;
        for (; i < nums.length; i++) {
            if ('0' <= nums[i] && nums[i] <= '9') {
                stringBuilder.append(nums[i]);
            } else if ('.' == nums[i] && !hasDot) {
                stringBuilder.append(nums[i]);
                hasDot = true;
            } else {
                break;
            }
        }
        double ans = Double.parseDouble(stringBuilder.toString());
        if (ans > Integer.MAX_VALUE) {
            if (-1 == isNeg) {
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }
        return (int) ans * isNeg;
    }
}
