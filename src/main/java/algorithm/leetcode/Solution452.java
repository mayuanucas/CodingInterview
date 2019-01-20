package algorithm.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: mayuan
 * @desc: 用最少数量的箭引爆气球
 * @date: 2018/08/19
 */
public class Solution452 {
    public static void main(String[] args) {
        int[][] arrays = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};

        Solution452 test = new Solution452();
        System.out.println(test.findMinArrowShots(arrays));
    }

    /**
     * 计算不重叠的区间个数，不过和 Non-overlapping Intervals 的区别在于，[1, 2] 和 [2, 3] 在本题中算是重叠区间
     *
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {
        if (null == points || 0 >= points.length) {
            return 0;
        }

        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowCnt = 1, arrowPos = points[0][1];
        for (int i = 1; i < points.length; ++i) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            ++arrowCnt;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }
}
