package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: H指数
 * @date: 2019/01/14
 */
public class Solution274 {

    public int hIndex(int[] citations) {
        if (null == citations || 0 >= citations.length) {
            return 0;
        }

        int N = citations.length;
        int[] buckets = new int[citations.length + 1];
        for (int i = 0; i < N; ++i) {
            if (citations[i] >= N) {
                ++buckets[N];
            } else {
                ++buckets[citations[i]];
            }
        }

        int cnt = 0;
        for (int i = N; i >= 0; --i) {
            cnt += buckets[i];
            if (i <= cnt) {
                return i;
            }
        }
        return 0;
    }

}
