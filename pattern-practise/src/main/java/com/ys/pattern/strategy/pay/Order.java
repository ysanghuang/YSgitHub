package com.ys.pattern.strategy.pay;

import com.ys.pattern.strategy.pay.payport.PayStategy;
import com.ys.pattern.strategy.pay.payport.Payment;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 15:19
 * @Version: 1.0
 */
public class Order {
    public String uid;
    public String orderId;
    public double price;

    public Order(String uid, String orderId, double price) {
        this.uid = uid;
        this.orderId = orderId;
        this.price = price;
    }

    public ResultMsg pay(){
        return pay(PayStategy.DEFAULT_PAY);
    }

    public ResultMsg pay(String payType){
        Payment payment = PayStategy.getPayStategy(payType);
        System.out.println("订单"+orderId+"开始支付......");
        System.out.println("本次消费金额为："+price);
        return payment.doPay(uid,price);
    }
}
