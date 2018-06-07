import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1095 {

    /**
     * 解题思路:
     * 将所有单词进行排序，查询时统计在未排序前相同的个数和排序后相同的个数，二者之差为答案。排序采用sort，统计采用map。
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        int number = 0;
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = bufferedReader.readLine();
            number = mapA.getOrDefault(words[i], 0) + 1;
            mapA.put(words[i], number);

            char[] temp = words[i].toCharArray();
            Arrays.sort(temp);
            number = mapB.getOrDefault(String.copyValueOf(temp), 0) + 1;
            mapB.put(String.copyValueOf(temp), number);
        }

        int q = Integer.parseInt(bufferedReader.readLine());
        String query = null;

        int ans1, ans2;
        for (int i = 0; i < q; i++) {
            query = bufferedReader.readLine();
            ans1 = mapA.getOrDefault(query, 0);

            char[] temp = query.toCharArray();
            Arrays.sort(temp);
            ans2 = mapB.getOrDefault(String.copyValueOf(temp), 0);

            bufferedWriter.write(ans2 - ans1 + "\n");
            bufferedWriter.flush();
        }

    }
}
