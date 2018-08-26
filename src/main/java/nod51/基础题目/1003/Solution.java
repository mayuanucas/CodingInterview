import java.util.Scanner;

/**
 * @author alpha
 * @date 2017/10/17
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        /**
         *  编程之美有讲：一个数 n 的阶乘末尾有多少个 0 取决于从 1 到 n 的各个数的因子中 2 和 5 的个数,
         *  而 2 的个数是远远多余 5 的个数的, 因此求出 5 的个数即可. 题解中给出的求解因子 5 的个数的方法是用 n 不断除以 5,
         *  直到结果为 0, 然后把中间得到的结果累加. 例如, 100/5 = 20, 20/5 = 4, 4/5 = 0,
         *  则 1 到 100 中因子 5 的个数为 (20 + 4 + 0) = 24 个, 即 100 的阶乘末尾有 24 个 0.
         *  其实不断除以 5, 是因为每间隔 5 个数有一个数可以被 5 整除, 然后在这些可被 5 整除的数中,
         *  每间隔 5 个数又有一个可以被 25 整除, 故要再除一次, ... 直到结果为 0, 表示没有能继续被 5 整除的数了.
         */
        int ans = 0;
        while (n>=5){
            ans += n/5;
            n /= 5;
        }

        System.out.println(ans);
    }
}
