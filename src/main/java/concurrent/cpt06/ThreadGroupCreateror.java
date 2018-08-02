package concurrent.cpt06;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/04
 */
public class ThreadGroupCreateror {
    public static void main(String[] args) {
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup group1 = new ThreadGroup("Group1");

        System.out.println(currentGroup.getName());
        System.out.println(group1.getParent() == currentGroup);

        ThreadGroup group2 = new ThreadGroup("Group2");

        System.out.println(group1.getName());
        System.out.println(group2.getParent() == group1);
    }
}
