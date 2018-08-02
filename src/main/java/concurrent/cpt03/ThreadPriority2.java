package concurrent.cpt03;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/30
 */
public class ThreadPriority2 {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("testGroup");
        // 将线程组的优先级指定为 7
        group.setMaxPriority(7);
        // 定义一个线程,将线程加入到 group 中
        Thread thread = new Thread(group, "test-thread");
        // 企图将线程的优先级设定为 10
        thread.setPriority(10);
        // 企图未遂
        System.out.println("线程真实优先级为: " + thread.getPriority());
    }

}
