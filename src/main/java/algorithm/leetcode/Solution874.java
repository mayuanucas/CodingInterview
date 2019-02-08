package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: mayuan
 * @desc: 模拟行走机器人
 * https://leetcode.com/problems/walking-robot-simulation/discuss/155682/Logical-Thinking-with-Clear-Code
 * @date: 2019/02/08
 */
public class Solution874 {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<String> set = new HashSet<>(obstacles.length);
        for (int[] e : obstacles) {
            set.add(e[0] + " " + e[1]);
        }

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0, d = 0, maxDistSquare = 0;

        for (int c : commands) {
            if (-1 == c) {
                ++d;
                d %= 4;
            } else if (-2 == c) {
                --d;
                if (0 > d) {
                    d += 4;
                }
            } else {
                while (c-- > 0 && !set.contains((x + dirs[d][0]) + " " + (y + dirs[d][1]))) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                }
            }

            maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
        }
        return maxDistSquare;
    }

}
