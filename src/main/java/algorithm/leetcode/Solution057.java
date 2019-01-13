package algorithm.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 插入区间
 * @date: 2019/01/13
 */
public class Solution057 {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (null == intervals || null == newInterval) {
            return intervals;
        }

        int i = 0;
        LinkedList<Interval> list = new LinkedList<>();
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            list.add(intervals.get(i));
            ++i;
        }
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            ++i;
        }
        list.add(newInterval);
        while (i < intervals.size()) {
            list.add(intervals.get(i));
            ++i;
        }
        return list;
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
