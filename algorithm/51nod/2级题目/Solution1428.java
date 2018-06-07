import java.io.*;
import java.util.*;

/**
 * @author mayuan
 * @desc
 * @date 2018/01/26
 */
public class Solution1428 {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        List<TimeNode> timeNodes = new ArrayList<>();
        int activeNumber = Integer.parseInt(bufferedReader.readLine());
        while (activeNumber > 0) {
            String[] temp = bufferedReader.readLine().split("\\s+");
            timeNodes.add(new TimeNode(Integer.parseInt(temp[0]), "start"));
            timeNodes.add(new TimeNode(Integer.parseInt(temp[1]), "end"));
            activeNumber--;
        }
        Collections.sort(timeNodes);

        int room = 0;
        int thickness = 0;
        for (TimeNode t : timeNodes) {
            if ("start".equals(t.getFlag())) {
                thickness++;
                if (thickness > room) {
                    room = thickness;
                }
            } else {
                thickness--;
            }
        }

        bufferedWriter.write(room + "\n");
        bufferedWriter.flush();
    }
}

class TimeNode implements Comparable<TimeNode> {
    private Integer time;
    private String flag;

    public TimeNode(int t, String f) {
        this.time = t;
        this.flag = f;
    }

    public Integer getTime() {
        return time;
    }

    public String getFlag() {
        return flag;
    }

    @Override
    public int compareTo(TimeNode timeNode) {
        return this.time.compareTo(timeNode.getTime());
    }
}