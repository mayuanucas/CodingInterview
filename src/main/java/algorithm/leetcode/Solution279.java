package algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/21
 */
public class Solution279 {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];

        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            ++level;
            int size = queue.size();
            while (size-- > 0) {
                int cur = queue.poll();
                for (int s : squares) {
                    int next = cur - s;
                    if (0 > next) {
                        break;
                    }
                    if (0 == next) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(cur - s);
                }
            }
        }
        return n;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        while (square <= n) {
            squares.add(square * square);
            ++square;
        }
        return squares;
    }
}
