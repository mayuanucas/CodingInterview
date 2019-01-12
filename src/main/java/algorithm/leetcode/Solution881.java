package algorithm.leetcode;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 救生艇
 * @date: 2019/01/12
 */
public class Solution881 {

    /**
     * 先对数组进行排序
     * i指针指向开始(体重轻),j指针指向末尾(体重重)
     * 重的人肯定能坐上船,因此j指针每次循环均能够减一.
     * 轻的人只有和重的人两个体重和不超过限制才能坐上船.
     *
     * @param people
     * @param limit
     * @return
     */
    public int numRescueBoats(int[] people, int limit) {
        if (null == people || 0 >= people.length) {
            return 0;
        }

        Arrays.sort(people);
        int ans = 0;
        for (int i = 0, j = people.length - 1; i <= j; --j, ++ans) {
            if (people[i] + people[j] <= limit) {
                ++i;
            }
        }
        return ans;
    }

}
