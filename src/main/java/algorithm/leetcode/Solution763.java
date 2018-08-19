package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/19
 */
public class Solution763 {
    public static void main(String[] args) {
        Solution763 test = new Solution763();

        List<Integer> ans = test.partitionLabels("ababcbacadefegdehijhklij");
        ans.forEach(System.out::println);
    }

    public List<Integer> partitionLabels(String S) {
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            lastIndexOfChar[charToIndex(S.charAt(i))] = i;
        }

        List<Integer> answer = new LinkedList<>();
        int firstIndex = 0;
        while (firstIndex < S.length()) {
            int lastIndex = firstIndex;
            for (int i = firstIndex; i <= lastIndex && i < S.length(); ++i) {
                int index = lastIndexOfChar[charToIndex(S.charAt(i))];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            answer.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return answer;
    }

    private int charToIndex(char c) {
        return c - 'a';
    }
}
