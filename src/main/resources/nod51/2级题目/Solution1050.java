import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2017/12/28
 */
public class Solution1050 {

    /**
     * 分析：本题与普通的最大子段和问题不同的是，最大子段和可以是首尾相接的情况，即可以循环。那么这个题目的最大子段和有两种情况
     *  (1）正常数组中间的某一段和最大。这个可以通过普通的最大子段和问题求出。
     *  (2）此数组首尾相接的某一段和最大。这种情况是由于数组中间某段和为负值，且绝对值很大导致的.
     *  那么我们只需要把中间的和为负值且绝对值最大的这一段序列求出，用总的和减去它就行了。
     *
     *  即，先对原数组求最大子段和，得到ans1，然后把数组中所有元素符号取反，再求最大子段和，得到ans2，
     *  原数组的所有元素和为ans，那么最终答案就是max(ans1, ans - (-ans2)) => max(ans1, ans+ans2)。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        long[] numbers = new long[n];
        long sumOfNUmbers = 0, ans = 0, ans1 = 0, ans2 = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(bufferedReader.readLine());
            sumOfNUmbers += numbers[i];
        }

        ans1 = Solution1050.countMaxArray(numbers);

        for (int i = 0; i < n; i++) {
            numbers[i] = -numbers[i];
        }

        ans2 = Solution1050.countMaxArray(numbers);

        ans = Math.max(ans1, sumOfNUmbers + ans2);

        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();

    }

    public static long countMaxArray(long[] numbers) {
        long sum = 0, max = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (0 > sum) {
                sum = numbers[i];
            } else {
                sum += numbers[i];
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

}
