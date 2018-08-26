import java.io.*;
import java.math.BigDecimal;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/21
 */
public class Solution1873 {

    /**
     * stripTrailingZeros() ：用于去除末尾多余的0
     * toPlainString()： 控制不使用科学计数法输出
     * 去掉前导“0.”就相对简单多了，只需要先将高精度浮点数转化为字符串再判断字符串开头即可。
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] temp = bufferedReader.readLine().split("\\s+");
        BigDecimal a = BigDecimal.valueOf(Double.parseDouble(temp[0]));
        int n = Integer.parseInt(temp[1]);

        BigDecimal ans = BigDecimal.ONE;
        while (0 != n) {
            if (1 == n % 2) {
                ans = ans.multiply(a);
            }

            a = a.multiply(a);
            n >>= 1;
        }

        String str = ans.stripTrailingZeros().toPlainString();
        if (str.startsWith("0.")) {
            str = str.substring(1, str.length());
        }

        bufferedWriter.write(str);
        bufferedWriter.flush();
    }
}
