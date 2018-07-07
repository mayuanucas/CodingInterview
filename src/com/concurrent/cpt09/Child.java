package com.concurrent.cpt09;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/07
 */
public class Child extends Parent {
    static {
        System.out.println("The child will be initialized.");
    }

    public static int x = 10;
}
