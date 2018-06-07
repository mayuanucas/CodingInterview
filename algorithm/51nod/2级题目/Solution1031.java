import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1031 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        /**
         * 思路：
         * 对于第x块骨牌的情况，我们用f[x]表示其方法数；其比x-1块骨牌时多了一块骨牌，多出的骨牌有两种放法：
         * １. 我们可以直接将其竖着添加在最末端，那么其排列数就为就是前x-1块骨牌的排列数，即为f[x-1]；
         * ２. 我们也可以将其和其前面一块骨牌一起横着放，那么其排列数就是前x-2块骨牌的排列数，即为f[x-2]；
         * 所以有　f[x]=f[x-1]+f[x-2]；(斐波那契数列)
         */
        int mod = (int) 1e9 + 7;
        int[] fib = new int[1005];
        fib[1] = fib[0] = 1;

        int n = Integer.parseInt(bufferedReader.readLine());

        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % mod;
        }

        bufferedWriter.write(fib[n] + "\n");
        bufferedWriter.flush();

    }
}