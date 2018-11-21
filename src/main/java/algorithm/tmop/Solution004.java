package algorithm.tmop;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 字符串的全排列
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date: 2018/11/21
 */
public class Solution004 {

    public static void main(String[] args) {
        final String input = "abc";
        List<String> answer = new LinkedList<>();

//        dfs(answer, new StringBuilder(), input, new boolean[input.length()]);
//
//        System.out.println("total number :" + answer.size());
//        for (String word : answer) {
//            System.out.println(word);
//        }

        permutation(input.toCharArray(), 0, input.length() - 1);
    }


    public static void dfs(List<String> answer, StringBuilder oneAnswer, String str, boolean[] choosed) {
        if (str.length() == oneAnswer.length()) {
            answer.add(oneAnswer.toString());
            return;
        }

        for (int i = 0; i < str.length(); ++i) {
            if (!choosed[i]) {
                oneAnswer.append(str.charAt(i));
                choosed[i] = true;
                dfs(answer, oneAnswer, str, choosed);
                choosed[i] = false;
                oneAnswer.deleteCharAt(oneAnswer.length() - 1);
            }
        }
    }

    /**
     * 采用交换元素的方式( 时间复杂度: O(n!) )
     * 以对字符串 "abc" 进行全排列为例:
     * 1.将字符 a 固定在第一位,求 bc 的全排列,得到: "abc" "acb"
     * 2.将字符 b 固定在第一位,求 ac 的全排列,得到: "bac" "bca"
     * 3.将字符 c 固定在第一位,求 ba 的全排列,得到: "cba" "cab"
     */
    public static void permutation(char[] array, int from, int to) {
        if (0 >= to) {
            return;
        }

        if (from == to) {
            for (int i = 0; i < array.length; ++i) {
                System.out.print(array[i]);
            }
            System.out.println();
        } else {
            for (int i = from; i <= to; ++i) {
                swap(array, from, i);
                permutation(array, from + 1, to);
                swap(array, i, from);
            }
        }
    }

    public static void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
