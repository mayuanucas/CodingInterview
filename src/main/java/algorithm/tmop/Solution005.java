package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 字符串转换成整数
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution005 {

    public static void main(String[] args) {
        final String str1 = "123";
        final String str2 = "-123";
        final String str3 = "-12aaa3";
        final String str4 = "12399999999999999999";

        System.out.println(strToInt(str1));
        System.out.println(strToInt(str2));
//        System.out.println(strToInt(str3));
        System.out.println(strToInt(str4));
    }

    public static int strToInt(String str) {
        if (null == str || 0 >= (str = str.trim()).length()) {
            throw new IllegalArgumentException();
        }

        long number = 0L;
        int sign = 1;
        int start = 0;

        if ('+' == str.charAt(0)) {
            start = 1;
        } else if ('-' == str.charAt(0)) {
            start = 1;
            sign = -1;
        }

        for (int i = start; i < str.length(); ++i) {
            char c = str.charAt(i);
            if ('0' > c || '9' < c) {
                throw new NumberFormatException("字符串非法");
            }

            number = number * 10 + (c - '0');

            if (sign * number > Integer.MAX_VALUE) {
                throw new NumberFormatException("超出int表示范围");
            } else if (sign * number < Integer.MIN_VALUE) {
                throw new NumberFormatException("超出int表示范围");
            }
        }

        return (int) (number * sign);
    }

}
