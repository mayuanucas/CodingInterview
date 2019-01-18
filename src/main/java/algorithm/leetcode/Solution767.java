package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 重构字符串
 * @date: 2019/01/18
 */
public class Solution767 {

    public static void main(String[] args) {
        System.out.println(new Solution767().reorganizeString("aab"));
    }

    public String reorganizeString(String S) {
        if (null == S || 1 >= S.length()) {
            return S;
        }

        int[] dict = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            ++dict[S.charAt(i) - 'a'];
        }

        int max = 0;
        for (int i = 0; i < dict.length; ++i) {
            if (dict[i] > dict[max]) {
                max = i;
            }
        }
        if (dict[max] > (1 + S.length()) / 2) {
            return "";
        }

        int start = 0;
        char[] newArray = new char[S.length()];
        for (int i = 0; i < newArray.length; i += 2) {
            // 需要先排列最多的字符,避免它们相邻.例如:"lvovv"
            if (0 < dict[max]) {
                newArray[i] = (char) ('a' + max);
                --dict[max];
            } else {
                while (0 == dict[start]) {
                    ++start;
                }
                newArray[i] = (char) ('a' + start);
                --dict[start];
            }
        }
        for (int i = 1; i < newArray.length; i += 2) {
            while (0 == dict[start]) {
                ++start;
            }
            newArray[i] = (char) ('a' + start);
            --dict[start];
        }

        return new String(newArray);
    }

}
