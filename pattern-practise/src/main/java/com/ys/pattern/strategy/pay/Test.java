package com.ys.pattern.strategy.pay;

import com.ys.pattern.strategy.pay.payport.PayStategy;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 14:53
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order("01","202003150001",200);
        System.out.println(order.pay(PayStategy.UNION_PAY));
    }
}
