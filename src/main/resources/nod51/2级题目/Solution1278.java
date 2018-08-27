import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1278 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        Circle[] circles = new Circle[n];


        for (int i = 0; i < n; ++i) {
            String[] temp = bufferedReader.readLine().split("\\s+");
            int p = Integer.parseInt(temp[0]);
            int r = Integer.parseInt(temp[1]);

            circles[i] = new Circle(p - r, p + r);
        }

        int ans = 0;
        Arrays.sort(circles, new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                if (o1.left != o2.left) {
                    return o1.left - o2.left;
                } else {
                    return o1.right - o2.right;
                }
            }
        });

        for (int i = 0; i < n; ++i) {
            int k = binarySearch(circles, i, n - 1, circles[i].right);
            ans += (n - 1 - k);
        }

        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }

    public static int binarySearch(Circle[] c, int lt, int rt, int k) {
        int left = lt;
        int right = rt;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (c[mid].left > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}

class Circle {
    public int left;
    public int right;

    public Circle(int left, int right) {
        this.left = left;
        this.right = right;
    }
}