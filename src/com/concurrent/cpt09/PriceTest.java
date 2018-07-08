package com.concurrent.cpt09;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/08
 */
public class PriceTest {
    public static void main(String[] args) {
        System.out.println(Price.instance.currentPrice);
        Price price = new Price(2.8);
        System.out.println(price.currentPrice);
    }
}
