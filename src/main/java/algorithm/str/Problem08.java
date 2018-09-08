package algorithm.str;

/**
 * @author: mayuan
 * @desc: 翻转字符串里的单词
 * @date: 2018/09/08
 */
public class Problem08 {

    public static void main(String[] args) {
        Problem08 test = new Problem08();

        String ans = test.reverseWords(" 1");
        System.out.println(ans);
    }

    public String reverseWords(String s) {
        if (null == s) {
            return s;
        }
        if (s.trim().length() == 0) {
            return s.trim();
        }

        String[] temp = s.trim().split("\\s+");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = temp.length - 1; i > 0; --i) {
            stringBuilder.append(temp[i] + " ");
        }
        stringBuilder.append(temp[0]);
        return stringBuilder.toString();
    }
}
