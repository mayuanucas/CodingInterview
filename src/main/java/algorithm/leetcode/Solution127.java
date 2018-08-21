package algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/21
 */
public class Solution127 {
    public static void main(String[] args) {

    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        int n = wordList.size();
        // start 为 beginWord 的位置
        int start = n - 1;
        // 查找 endWord 的位置
        int end = 0;
        while (end < n && !wordList.get(end).equals(endWord)) {
            ++end;
        }
        if (end == n) {
            return 0;
        }

        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic, start, end);
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] marked = new boolean[graphic.length];

        queue.add(start);
        marked[start] = true;
        int path = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ++path;
            while (size-- > 0) {
                int cur = queue.poll();
                for (int next : graphic[cur]) {
                    if (next == end) {
                        return path;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int n = wordList.size();
        List<Integer>[] graphic = new List[n];
        for (int i = 0; i < n; ++i) {
            graphic[i] = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if (isConnect(wordList.get(i), wordList.get(j))) {
                    graphic[i].add(j);
                }
            }
        }
        return graphic;
    }

    /**
     * 判断两个字符串是否仅有一个字符的差异
     *
     * @param s1
     * @param s2
     * @return
     */
    private boolean isConnect(String s1, String s2) {
        int diffCnt = 0;
        for (int i = 0; i < s1.length() && diffCnt <= 1; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++diffCnt;
            }
        }
        return 1 == diffCnt;
    }
}
