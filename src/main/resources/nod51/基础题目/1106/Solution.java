import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalNumber = sc.nextInt();
        while (0 < (totalNumber--)) {
            if (Solution.isPrimeNumber(sc.nextInt())) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean isPrimeNumber(int number) {
        if ((0 == number % 2) && (2 != number)){
            return false;
        } else {
            int maxTryNumber = (int)Math.sqrt(number) + 1;
            // 已经判断该数字为奇数 因此每次循环的时候增2就可以
            for (int i = 3; i <= maxTryNumber; i+=2) {
                if (0 == (number % i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
