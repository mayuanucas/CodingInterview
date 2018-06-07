import java.io.*;
import java.util.Arrays;

/**
 * @author mayuan
 * @desc
 * @date 2017/11/29
 */
public class Solution1091 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        int n = Integer.parseInt(bufferedReader.readLine());
        Line[] shuzu = new Line[n];
        for (int i = 0; i < n; i++) {
            String[] temp = bufferedReader.readLine().split("\\s+");
            shuzu[i] = new Line(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
        Arrays.sort(shuzu);

        int ans = 0, pre = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.min(pre, shuzu[i].getEnd()) - shuzu[i].getStart());
            if (pre < shuzu[i].getEnd()) {
                pre = shuzu[i].getEnd();
            }
        }

        bufferedWriter.write(ans + "\n");
        bufferedWriter.flush();
    }
}

class Line implements Comparable<Line> {
    int start, end;

    public Line() {
    }

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(Line o) {
        if (start < o.getStart()) {
            return -1;
        } else if (start == o.getStart()) {
            return 0;
        } else {
            return 1;
        }
    }
}