package algorithm.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 合并区间
 * @date: 2019/01/13
 */
public class Solution056 {

    public List<Interval> merge(List<Interval> intervals) {
        if (null == intervals) {
            return intervals;
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        LinkedList<Interval> result = new LinkedList<>();
        for (Interval e : intervals) {
            if (result.isEmpty() || result.getLast().end < e.start) {
                result.add(e);
            } else {
                result.getLast().end = Math.max(result.getLast().end, e.end);
            }
        }
        return result;
    }

    private class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
