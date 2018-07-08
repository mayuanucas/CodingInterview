package com.concurrent.cpt09;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/07/08
 */
public class Price {

    final static Price instance = new Price(2.8);

    static double initPrice = 20;

    double currentPrice;

    public Price(double discount){
        currentPrice = initPrice - discount;
    }
}
