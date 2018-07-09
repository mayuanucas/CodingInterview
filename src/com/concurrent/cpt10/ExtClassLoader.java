package com.concurrent.cpt10;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/09
 */
public class ExtClassLoader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(ExtClassLoader.class.getClassLoader());
    }
}
