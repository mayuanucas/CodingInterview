package com.concurrent.cpt02;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/06/28
 */
public class ThreadConstruction {

    public static void main(String[] args) {
        Thread t1 = new Thread("t1");

        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group, "t2");

        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        System.out.println("Main thread belong to " + mainGroup.getName() + " group.");
        System.out.println("t1 thread belong to " + t1.getThreadGroup().getName() + " group.");
        System.out.println("t2 thread belong to " + t2.getThreadGroup().getName() + " group.");

    }
}
