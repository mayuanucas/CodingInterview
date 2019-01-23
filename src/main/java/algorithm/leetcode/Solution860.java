package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 柠檬水找零
 * @date: 2019/01/23
 */
public class Solution860 {

    public boolean lemonadeChange(int[] bills) {
        if (null == bills || 0 >= bills.length) {
            return true;
        }

        int d5 = 0;
        int d10 = 0;
        for (int e : bills) {
            if (5 == e) {
                ++d5;
            } else if (10 == e) {
                // 找零5美元
                if (0 < d5) {
                    ++d10;
                    --d5;
                } else {
                    return false;
                }
            } else {
                // 找零15美元
                // 1. d10 + d5 (一张10美元+一张5美元)
                // 2. 3*d5 (三张5美元)
                // 3. 无法找零
                if (0 < d10 && 0 < d5) {
                    --d10;
                    --d5;
                } else if (3 <= d5) {
                    d5 -= 3;
                } else {
                    // 无法找零
                    return false;
                }
            }
        }
        return true;
    }

}
