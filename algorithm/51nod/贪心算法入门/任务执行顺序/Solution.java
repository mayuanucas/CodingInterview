import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int taskNumber = sc.nextInt();
            List<Task> tasks = new ArrayList<>();
            while (taskNumber > 0) {
                tasks.add(new Task(sc.nextInt(), sc.nextInt()));
                taskNumber--;
            }
            Collections.sort(tasks, Collections.reverseOrder());    //根据程序释放回的内存量 从大到小排序

            int occupySpace = 0;        // 当前已经必须占用的内存
            int minNeedSpace = 0;       //最小需要的内存
            for (Task t : tasks) {
                minNeedSpace = minNeedSpace > occupySpace + t.getRunUsed() ? minNeedSpace : occupySpace + t.getRunUsed();
                occupySpace += t.getOccupy();
            }
            System.out.println(minNeedSpace);
        }
    }
}

class Task implements Comparable<Task> {
    private Integer runUsed;
    private Integer occupy;
    private Integer back;

    public Task(int r, int o) {
        this.runUsed = r;
        this.occupy = o;
        this.back = this.runUsed - this.occupy;
    }

    public Integer getRunUsed() {
        return runUsed;
    }

    public Integer getOccupy() {
        return occupy;
    }

    public Integer getBack() {
        return back;
    }

    @Override
    public int compareTo(Task t) {
        return this.back.compareTo(t.getBack());
    }
}