package algorithm.alg4;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/09/30
 */
public class MyUtil {

    public static void main(String[] args) {
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
    }

    /**
     * 判断一个数是不是素数
     *
     * @param n
     * @return
     */
    public static boolean isPrime(int n) {
        if (2 > n) {
            return false;
        }

        for (int i = 2; i * i <= n; ++i) {
            if (0 == n % i) {
                return false;
            }
        }
        return true;
    }
}
