package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * @date: 2018/11/20
 */
public class Solution002 {

    public static void main(String[] args) {
        final String input = "I am a student.";

        System.out.println(reverseSentence(input));
    }

    public static String reverseSentence(String text) {
        if (null == text || 0 >= text.length()) {
            return null;
        }

        String[] tmp = text.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = tmp.length - 1; i >= 0; --i) {
            stringBuilder.append(tmp[i]);
            if (0 != i) {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString();
    }

}
