package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 出现次数超过一半的数
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @date:
 */
public class Solution020 {

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 3, 3, 0, 3};

        System.out.println(findNumber(array));
    }

    public static int findNumber(int[] array) {
        if (null == array || 0 >= array.length) {
            return -1;
        }

        int number = array[0];
        int count = 1;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] == number) {
                ++count;
            } else {
                if (1 == count) {
                    number = array[i];
                } else {
                    --count;
                }
            }
        }
        return number;
    }
}
