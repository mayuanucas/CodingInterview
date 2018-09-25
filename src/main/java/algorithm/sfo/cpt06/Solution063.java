package algorithm.sfo.cpt06;

/**
 * @author: mayuan
 * @desc: 股票的最大利润
 * @date: 2018/09/25
 */
public class Solution063 {

    public static void main(String[] args) {
        int[] numbers = {9, 11, 8, 5, 7, 12, 16, 14};

        final int answer = 11;

        System.out.println(answer == getMaxValue(numbers));
    }

    /**
     * 思路: 在卖出价固定时,买入价越低获得的利润越大.
     * 在扫描到数组中的第 i 个数字时,只要能够记住之前的 i-1 个数字中的最小值,就能够算出当前价位卖出时可能得到的最大利润.
     *
     * @param array
     * @return
     */
    public static int getMaxValue(int[] array) {
        if (null == array || 2 > array.length) {
            return -1;
        }

        int minNumber = array[0];
        int maxValue = array[1] - array[0];

        for (int i = 2; i < array.length; ++i) {
            if (array[i - 1] < minNumber) {
                minNumber = array[i - 1];
            }

            int current = array[i] - minNumber;
            if (current > maxValue) {
                maxValue = current;
            }
        }

        return maxValue;
    }
}
