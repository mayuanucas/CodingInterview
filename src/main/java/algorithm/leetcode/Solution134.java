package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 加油站
 * @date: 2019/01/19
 */
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int debt = 0, remain = 0;
        int start = 0;

        for (int i = 0; i < gas.length; ++i) {
            remain += gas[i] - cost[i];
            // 环路,最终还要回到出发点,欠款总是要还上的
            if (0 > remain) {
                debt += remain;
                start = i + 1;
                remain = 0;
            }
        }
        return remain + debt < 0 ? -1 : start;
    }

}
