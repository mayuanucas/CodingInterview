package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 划分字母区间
 * @date: 2018/08/19
 */
public class Solution763 {
    public static void main(String[] args) {
        Solution763 test = new Solution763();

        List<Integer> ans = test.partitionLabels("ababcbacadefegdehijhklij");
        ans.forEach(System.out::println);
    }

    public List<Integer> partitionLabels(String S) {
        int[] map = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            map[S.charAt(i) - 'a'] = i;
        }

        List<Integer> answer = new LinkedList<>();
        int start = 0, last = 0;
        for (int i = 0; i < S.length(); ++i) {
            last = last > map[S.charAt(i) - 'a'] ? last : map[S.charAt(i) - 'a'];
            if (last == i) {
                answer.add(last - start + 1);
                start = last + 1;
            }
        }
        return answer;
    }

}
