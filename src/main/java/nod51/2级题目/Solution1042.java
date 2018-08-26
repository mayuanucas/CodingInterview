import java.io.*;
import java.math.BigInteger;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1042 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");

        long left = Long.parseLong(temp[0]);
        long right = Long.parseLong(temp[1]);

        BigInteger[] a = new BigInteger[10];
        BigInteger[] b = new BigInteger[10];

        init(a);
        init(b);

        dp(right, 1, a);
        dp(left-1, 1, b);

        for (int i=0; i<=9; ++i){
            bufferedWriter.write(a[i].subtract(b[i]) + "\n");
            bufferedWriter.flush();
        }


    }

    public static void dp(long n, long m, BigInteger[] c){
        long x = n % 10;
        long y = n / 10;

        /**
         * 当前位对低位的影响，每个都是0~9的范围
         */
        for (int i=0; i<=x; ++i){
            c[i] = c[i].add(BigInteger.valueOf(m));
        }

        /**
         * 当前位对的高位影响（高位不为0，在上一个循环中算过）
         */
        for (int i=0; i<=9; ++i){
            c[i] = c[i].add(BigInteger.valueOf(m*y));
        }

        /**
         * 排除前导0的情况
         */
        c[0] = c[0].subtract(BigInteger.valueOf(m));

        long t = y;
        while (0 < t){
            c[(int)(t % 10)] = c[(int)(t % 10)].add(BigInteger.valueOf((x+1) * m));
            t /= 10;
        }

        /**
         * y值在上个while中算过，算下一个未限制数
         */
        if (0 < y){
            dp(y-1, m*10, c);
        }
    }

    public static void init(BigInteger[] array){
        for (int i=0; i<array.length; ++i){
            array[i] = new BigInteger("0");
        }
    }
}