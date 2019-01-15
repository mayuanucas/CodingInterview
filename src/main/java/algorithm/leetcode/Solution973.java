package algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: mayuan
 * @desc:  最接近原点的 K 个点
 * @date: 2019/01/15
 */
public class Solution973 {

    public int[][] kClosest(int[][] points, int K) {
        if (null == points || K >= points.length) {
            return points;
        }

        Arrays.sort(points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
        return Arrays.copyOfRange(points, 0, K);
    }

}
