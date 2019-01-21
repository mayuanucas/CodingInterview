package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 任务调度器
 * @date: 2019/01/21
 */
public class Solution621 {

    public int leastInterval(char[] tasks, int n) {
        int[] dict = new int[26];
        for (char c : tasks) {
            ++dict[c - 'A'];
        }

        // 出现次数最多的任务,其总次数
        int maxNumber = 0;
        // 总次数最大,任务数量
        int sameCnt = 1;
        for (int e : dict) {
            if (maxNumber < e) {
                maxNumber = e;
                sameCnt = 1;
            } else if (maxNumber == e) {
                ++sameCnt;
            }
        }

        int space = (n + 1) * (maxNumber - 1) + sameCnt;
        return space < tasks.length ? tasks.length : space;
    }

}
