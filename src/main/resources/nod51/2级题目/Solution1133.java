import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1133 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out), 1 << 16);

        List<Active> actives = new ArrayList<>();
        int activeNumber = Integer.parseInt(bufferedReader.readLine());
        while (activeNumber > 0) {
            String[] temp = bufferedReader.readLine().split("\\s+");
            actives.add(new Active(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
            activeNumber--;
        }
        Collections.sort(actives);

        int result = 0;
        //测试数据有负数 因此此处必须为最小值
        int lastEndTime = Integer.MIN_VALUE;
        for (Active a : actives) {
            if (a.getStart() >= lastEndTime) {
                result++;
                //该活动可以安排 则更新上一个活动的结束时间
                lastEndTime = a.getEnd();
            }
        }
        bufferedWriter.write(result + "\n");
        bufferedWriter.flush();
    }
}

class Active implements Comparable<Active> {
    private Integer start;
    private Integer end;

    public Active() {
        this.start = 0;
        this.end = 0;
    }

    public Active(Integer s, Integer e) {
        this.start = s;
        this.end = e;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    @Override
    public int compareTo(Active active) {
        return this.end.compareTo(active.end);
    }
}