package learn;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/23
 */
public class TwoThreadWaitNotify {

    private int currentNumber = 1;

    private boolean flag = false;

    public static void main(String[] args) {
        TwoThreadWaitNotify t = new TwoThreadWaitNotify();

        Thread t1 = new Thread(new Even(t), "Even");
        Thread t2 = new Thread(new Odd(t), "Odd");

        t1.start();
        t2.start();
    }

    /**
     * 奇数线程
     */
    private static class Odd implements Runnable {
        private TwoThreadWaitNotify number;

        public Odd(TwoThreadWaitNotify twoThreadWaitNotify) {
            this.number = twoThreadWaitNotify;
        }

        @Override
        public void run() {
            while (100 >= number.currentNumber) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("奇数线程抢到了锁.");
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "->" + number.currentNumber);
                        number.currentNumber++;

                        number.flag = true;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /**
     * 偶数线程
     */
    private static class Even implements Runnable {
        private TwoThreadWaitNotify number;

        public Even(TwoThreadWaitNotify twoThreadWaitNotify) {
            this.number = twoThreadWaitNotify;
        }

        @Override
        public void run() {
            while (100 >= number.currentNumber) {
                synchronized (TwoThreadWaitNotify.class) {
                    System.out.println("偶数线程抢到锁了.");
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "->" + number.currentNumber);
                        number.currentNumber++;

                        number.flag = false;
                        TwoThreadWaitNotify.class.notify();
                    } else {
                        try {
                            TwoThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
