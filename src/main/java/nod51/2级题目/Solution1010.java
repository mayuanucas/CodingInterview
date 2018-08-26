import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1010 {
    public static long INF = (long) 1e18 + 100;

    public static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        init();

        int testNumber = Integer.parseInt(bufferedReader.readLine());
        while (0 < testNumber--) {
            long n = Long.parseLong(bufferedReader.readLine());
            long l = 1L, r = list.size(), mid = 1L;
            while (l < r) {
                mid = (l + r) >> 1;
                if (n <= list.get((int) mid)) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            bufferedWriter.write(list.get((int) l).toString() + "\n");
            bufferedWriter.flush();
        }
    }

    public static void init() {
        long i, j, k;
        for (i = 1; i < INF; i *= 2) {
            for (j = 1; i * j < INF; j *= 3) {
                for (k = 1; i * j * k < INF; k *= 5) {
                    list.add(i * j * k);
                }
            }
        }
        list.sort(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return o1.compareTo(o2);
            }
        });
    }
}