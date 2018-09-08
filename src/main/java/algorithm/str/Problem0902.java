package algorithm.str;

/**
 * @author: mayuan
 * @desc: 反转字符串
 * @date: 2018/09/08
 */
public class Problem0902 {
    public String reverseString(String s) {
        if (null == s || s.length() <= 1) {
            return s;
        }

        char[] temp = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = temp.length - 1; i >= 0; --i) {
            stringBuilder.append(temp[i]);
        }
        return stringBuilder.toString();
    }
}
