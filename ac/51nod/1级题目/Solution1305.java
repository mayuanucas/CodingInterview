import java.io.*;
import java.util.Arrays;
import java.util.Stack;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1305 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        long sum = 0L;

        /**
         * 组合问题： 2 只有与 2 做题目给出的运算时才是 1，与其他数字做运算是 0
         * 按照题目给出的规则：
         * 假定 a1 a2 a3 an-1 4个数为2，则组合情况如下：(等差数列求和：(首项+尾项)*项数/2)
         * a1,a2 a1,a3 a1,an-1;   3种
         * a2,a3 a2,an-1;         2种
         * a3,an-1                1种
         * 则有  （1 + 4-1）* 4 / 2
         */
        int temp = 0, num2 = 0;
        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(bufferedReader.readLine());
            if (2 == temp) {
                num2++;
            } else if (1 == temp) {
                sum += (n - 1);
            }
        }
        bufferedWriter.write(sum + num2 * (num2 - 1) / 2 + "\n");
        bufferedWriter.flush();
    }
}