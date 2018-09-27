package algorithm.note;

/**
 * @author: mayuan
 * @desc:  实现字符串到数字的解析
 * @date: 2018/09/24
 */
public class StrToNumber {
    public static void main(String[] args) {
        String num = "-99991234";

        System.out.println(parseInt(num));
    }

    /**
     * 将字符串转换为数字
     *
     * @param str
     * @return
     */
    public static int parseInt(String str) {
        if (null == str) {
            throw new IllegalArgumentException();
        }

        str = str.trim();
        if (0 == str.length()) {
            throw new IllegalArgumentException();
        }

        // 标记: 1代表整数, -1代表负数
        int sign = 1;
        // 指针,代表当前处理的位置
        int index = 0;
        // 取得数字部分,遇到溢出或者字符串中有非数字字符则报错
        long number = 0L;

        // 判断字符串首字符是否为正负号
        if ('+' == str.charAt(0)) {
            ++index;
        } else if ('-' == str.charAt(0)) {
            sign = -1;
            ++index;
        }

        for (; index < str.length(); ++index) {
            char c = str.charAt(index);

            if ('0' > c || '9' < c) {
                throw new NumberFormatException();
            }

            number = number * 10 + (c - '0');

            if (sign * number > Integer.MAX_VALUE) {
                throw new NumberFormatException();
            }
            if (sign * number < Integer.MIN_VALUE) {
                throw new NumberFormatException();
            }
        }

        return (int) number * sign;
    }
}
