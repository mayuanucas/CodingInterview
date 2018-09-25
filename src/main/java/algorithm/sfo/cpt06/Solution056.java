package algorithm.sfo.cpt06;

import java.util.Arrays;
import java.util.List;

/**
 * @author: mayuan
 * @desc: 数组中只出现一次的两个数字
 * @date: 2018/09/25
 */
public class Solution056 {
    public static void main(String[] args) {
        // 答案为 4 6
        int[] numbers = {2, 4, 3, 6, 3, 2, 5, 5};

        List<Integer> ans = findAppearOnceNumber(numbers);
        ans.forEach(System.out::println);
    }

    /**
     * 数组中仅有1个数字出现1次,其余数字都出现2次. 那么对数组中的所有数字进行异或,最终可得到答案.
     * 数组中有2个数字出现1次,其余数字都出现2次. 那么对数组中的所有数字进行异或,最终得到的是这2个数字(仅出现1次)进行异或运算的结果.
     * 将该数组分为两个数组,使得这2个出现1次的数字被分到不同的数组中.分组的依据: 找到异或结果的二进制表示中第一个为1的bit位,记录该位置.
     * 判断数组中每个数字的该位置是否为1,以此进行分组.(相同的数字会处在同一组)
     *
     * @param array
     * @return
     */
    public static List<Integer> findAppearOnceNumber(int[] array) {
        if (null == array || 2 > array.length) {
            return null;
        }

        int resultOr = 0;
        for (int i = 0; i < array.length; ++i) {
            resultOr ^= array[i];
        }

        int oneBitIndex = findFirstOneBit(resultOr);
        int num0 = 0, num1 = 0;

        for (int i = 0; i < array.length; ++i) {
            if (isBitOne(array[i], oneBitIndex)) {
                num1 ^= array[i];
            } else {
                num0 ^= array[i];
            }
        }
        return Arrays.asList(num0, num1);
    }

    /**
     * 判断该数字的二进制表示的第 index 位(从右开始计数)数字是否为 1.
     *
     * @param number
     * @param index
     * @return
     */
    public static boolean isBitOne(int number, int index) {
        number = number >>> index;
        return 1 == (number & 1);
    }

    /**
     * 从数字的二进制表示的最低位开始查找(从最右侧),找到第一个为 1 的二进制位
     *
     * @param number
     * @return
     */
    public static int findFirstOneBit(int number) {
        int index = 0;
        while (0 == (number & 1) && 32 > index) {
            // 采用无符号右移
            number = number >>> 1;
            ++index;
        }
        return index;
    }

}
