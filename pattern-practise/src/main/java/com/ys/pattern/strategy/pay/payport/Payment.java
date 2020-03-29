package com.ys.pattern.strategy.pay.payport;

import com.ys.pattern.strategy.pay.ResultMsg;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 14:53
 * @Version: 1.0
 */
public abstract class Payment {

    public abstract String getPayName();

    public abstract double queryBalance(String uid);

    public ResultMsg doPay(String uid, double account){
        if(queryBalance(uid) < account){
//            System.out.println("余额不足，支付失败");
            return new ResultMsg("0001","余额不足，支付失败");
        }
        System.out.println("支付方式："+getPayName()+",现有余额："+queryBalance(uid));
//        System.out.println("开始成功,余额："+(queryBalance(uid)-account));
        return new ResultMsg("0000","支付成功,余额："+(queryBalance(uid)-account));
    }
}
