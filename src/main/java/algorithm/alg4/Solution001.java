package algorithm.alg4;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/19
 */
public class Solution001 {

    public static void main(String[] args) {
        System.out.println(gcd(12, 8));
        System.out.println(lcm(12, 8));
    }

    /**
     * 求两个数的最大公约数
     *
     * @param maxNumber 较大的数字
     * @param minNumber 较小的数字
     * @return
     */
    public static int gcd(int maxNumber, int minNumber) {
        if (0 == minNumber) {
            return maxNumber;
        }

        while (0 != minNumber) {
            int tmp = maxNumber % minNumber;
            maxNumber = minNumber;
            minNumber = tmp;
        }
        return maxNumber;
    }

    /**
     * 求两个数字的最小公倍数
     *
     * @param maxNumber 较大的数字
     * @param minNumber 较小的数字
     * @return
     */
    public static int lcm(int maxNumber, int minNumber) {
        return maxNumber * minNumber / gcd(maxNumber, minNumber);
    }
}
