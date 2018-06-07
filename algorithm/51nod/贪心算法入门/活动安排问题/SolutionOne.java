import java.util.*;

public class SolutionOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Active> actives = new ArrayList<>();
        int activeNumber = sc.nextInt();
        while (activeNumber > 0) {
            actives.add(new Active(sc.nextInt(), sc.nextInt()));
            activeNumber--;
        }
        Collections.sort(actives);

        int result = 0;
        int lastEndTime = Integer.MIN_VALUE;        //测试数据有负数 因此此处必须为最小值
        for (Active a : actives) {
            if (a.getStart() >= lastEndTime) {
                result++;
                lastEndTime = a.getEnd();           //该活动可以安排 则更新上一个活动的结束时间
            }
        }
        System.out.println(result);
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