package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:  删列造序
 * @date: 2019/02/12
 */
public class Solution944 {
    public int minDeletionSize(String[] A) {
        int cnt = 0;
        for (int i = 0; i < A[0].length(); ++i) {
            for (int j = 1; j < A.length; ++j) {
                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    ++cnt;
                    break;
                }
            }
        }
        return cnt;
    }
}
