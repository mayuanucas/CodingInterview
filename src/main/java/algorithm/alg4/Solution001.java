package algorithm.alg4;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/19
 */
public class Solution001 {

    public static void main(String[] args) {
        System.out.println(gcd1(12, 18));
        System.out.println(gcd1(18, 12));
        System.out.println(gcd2(12, 18));
        System.out.println(gcd2(18, 12));
        System.out.println(lcm(12, 18));
    }

    /**
     * 求 a 与 b 这两个数字的最大公约数(递归)
     * 欧几里得算法:
     * 计算两个非负整数 a 和 b 的最大公约数,若 b 为 0,则最大公约数为 a.
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd1(int a, int b) {
        return 0 == b ? a : gcd1(b, a % b);
    }

    /**
     * 求 a 与 b 这两个数字的最大公约数(非递归)
     *
     * @param a
     * @param b
     * @return
     */
    public static int gcd2(int a, int b) {
        while (0 != b) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    /**
     * 求 a 与 b 这两个数字的最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    public static int lcm(int a, int b) {
        return a * b / gcd1(a, b);
    }
}
