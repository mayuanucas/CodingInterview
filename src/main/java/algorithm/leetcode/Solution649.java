package algorithm.leetcode;

import java.util.ArrayDeque;

/**
 * @author Administrator
 * @desc Dota2 参议院
 * @create 2019/01/22
 */
public class Solution649 {

    public String predictPartyVictory(String senate) {
        ArrayDeque<Integer> r = new ArrayDeque<>();
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < senate.length(); ++i) {
            if ('R' == senate.charAt(i)) {
                r.add(i);
            } else {
                d.add(i);
            }
        }

        int n = senate.length();
        while (!r.isEmpty() && !d.isEmpty()) {
            int r_id = r.pollFirst();
            int d_id = d.pollFirst();
            if (r_id < d_id) {
                r.addLast(r_id + n);
            } else {
                d.addLast(d_id + n);
            }
        }

        return r.size() > d.size() ? "Radiant" : "Dire";
    }

}
