package com.concurrent.cpt09;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/07
 */
public class ClassInit {

    static {
        try {
            System.out.println("The ClassInit static code block will be invoke.");
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> new Thread((ClassInit::new)));
    }
}
