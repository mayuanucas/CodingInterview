import java.io.*;
import java.math.BigDecimal;

/**
 * @author alpha
 * @date 2017/10/26
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        // (1 + √5) / 2 ≈ 1.618
        // 假定 heapA 总是小于 heapB, 则 1.618 * （heapB - heapA）== heapA时，heapB赢。
        BigDecimal g = new BigDecimal("1.618033988749894848204586834");

        int testNumber = Integer.parseInt(bufferedReader.readLine());
        while (0 < testNumber--) {
            String[] s = bufferedReader.readLine().split("\\s+");
            // 输入数据非常大 此处应使用 Long
            long heapA = Long.parseLong(s[0]);
            long headB = Long.parseLong(s[1]);

            if (heapA > headB) {
                long temp = heapA;
                heapA = headB;
                headB = temp;
            }
            long result = g.multiply(new BigDecimal(headB - heapA)).longValue();
            if (result == heapA) {
                bufferedWriter.write("B\n");
            } else {
                bufferedWriter.write("A\n");
            }
            bufferedWriter.flush();
        }
    }
}
