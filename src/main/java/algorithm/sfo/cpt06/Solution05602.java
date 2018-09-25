package algorithm.sfo.cpt06;

/**
 * @author: mayuan
 * @desc: 数组中仅有一个数字出现1次, 其余数字都出现了三次, 找出这个数字.
 * @date: 2018/09/25
 */
public class Solution05602 {

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 2, 2, 2, 5, 3, 3, 3};

        System.out.println(findAppearOnceNumber(numbers));
    }

    /**
     * 采用位运算的思路:将所有数字都采用二进制的表示形式,int类型采用32个bit位来表示.
     * 将对应的bit位相加,如果该位置的和能被3整除,则对应所求数字的该位置为0; 不能被3整除,则对应所求数字的该位置为1.
     *
     * @param array
     * @return
     */
    public static int findAppearOnceNumber(int[] array) {
        int[] bit = new int[32];

        for (int i = 0; i < array.length; ++i) {
            int bitMask = 1;
            for (int j = 31; j >= 0; --j) {
                if (0 != (array[i] & bitMask)) {
                    ++bit[j];
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < bit.length; ++i) {
            result = result << 1;
            result += (bit[i] % 3);
        }

        return result;
    }
}
