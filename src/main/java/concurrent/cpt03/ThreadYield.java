package concurrent.cpt03;

import java.util.stream.IntStream;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/29
 */
public class ThreadYield {

    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {
            if (0 == index) {
                Thread.yield();
            }
            System.out.println(index);
        });
    }

}
