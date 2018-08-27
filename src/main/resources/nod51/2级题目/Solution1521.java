import java.io.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1521 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        String[] temp = bufferedReader.readLine().split("\\s+");
        int n = Integer.parseInt(temp[0]);
        int k = Integer.parseInt(temp[1]);
        int a = Integer.parseInt(temp[2]);
        int m = Integer.parseInt(bufferedReader.readLine());
        int[] id = new int[m];
        String[] tmp = bufferedReader.readLine().split("\\s+");
        for (int i = 0; i < m; i++) {
            id[i] = Integer.parseInt(tmp[i]);
        }


        boolean[] mark = new boolean[2 * n];
        boolean flag = true;
        int num = (n + 1) / (a + 1);
        int x;
        for (int i = 0; i < m; i++) {
            x = id[i];
            int left = x - 1, right = x + 1;
            mark[x] = true;
            while (left >= 1 && !mark[left]) {
                left--;
            }
            while (right <= n && !mark[right]) {
                right++;
            }
            num -= (right - left) / (a + 1) - (x - left) / (a + 1) - (right - x) / (a + 1);
            if (num < k) {
                bufferedWriter.write(i + 1 + "\n");
                bufferedWriter.flush();
                flag = false;
                break;
            }
        }
        if (flag) {
            bufferedWriter.write("-1\n");
            bufferedWriter.flush();
        }
    }
}
