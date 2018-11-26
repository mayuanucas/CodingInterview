package algorithm.tmop;

import java.util.Arrays;

/**
 * @author: mayuan
 * @desc: 寻找和为定值的两个数
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution009 {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 7, 11, 15};
        final int target = 15;

        Arrays.sort(array);

        twoSum(array, target);
    }

    /**
     * 在数组有序的情况下(数组无序的情况下,可以采用哈希表)
     *
     * @param array
     * @param target
     */
    public static void twoSum(int[] array, int target) {
        if (null == array || 1 >= array.length) {
            return;
        }

        int begin = 0;
        int end = array.length - 1;

        while (begin < end) {
            int tmp = array[begin] + array[end];

            if (target == tmp) {
                System.out.println(array[begin] + ", " + array[end]);

                // 如果是输出所有满足条件的数对,则需要增加下面这两条语句
//                ++begin;
//                --end;
                break;
            } else {
                if (target > tmp) {
                    ++begin;
                } else {
                    --end;
                }
            }
        }
    }

}
