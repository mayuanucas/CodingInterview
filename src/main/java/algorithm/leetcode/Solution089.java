package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 格雷编码
 * @date: 2018/08/12
 */
public class Solution089 {
    public static void main(String[] args) {
        Solution089 test = new Solution089();
        List<Integer> ans = test.grayCode(2);

        ans.forEach(System.out::println);
    }

    /**
     * 此题定义 格雷编码序列必须以 0 开头
     * 给定编码总位数为 n 的格雷编码序列，其长度为 2^n。当 n = 0 时，长度为 2^0 = 1。
     * 因此，当 n = 0 时，其格雷编码序列为 [0]。
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> answer = new LinkedList<>();
        for (int i = 0; i < Math.pow(2, n); i++) {
            answer.add(i ^ (i >> 1));
        }
        return answer;
    }
}
