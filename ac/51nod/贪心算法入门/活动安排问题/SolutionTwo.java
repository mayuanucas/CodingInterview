import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SolutionTwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<TimeNode> timeNodes = new ArrayList<>();
        int activeNumber = sc.nextInt();
        while (activeNumber > 0){
            timeNodes.add(new TimeNode(sc.nextInt(), "start"));
            timeNodes.add(new TimeNode(sc.nextInt(), "end"));
            activeNumber--;
        }
        Collections.sort(timeNodes);

        int room = 0;
        int thickness = 0;
        for (TimeNode t : timeNodes) {
            if ("start".equals(t.getFlag())){
                thickness++;
                if(thickness > room){
                    room = thickness;
                }
            } else {
                thickness--;
            }
        }
        System.out.println(room);
    }
}

class TimeNode implements Comparable<TimeNode>{
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
    public int compareTo(TimeNode timeNode){
        return this.time.compareTo(timeNode.getTime());
    }
}