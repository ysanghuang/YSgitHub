package com.ys.pattern.strategy.pay.payport;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 15:02
 * @Version: 1.0
 */
public class WeChatPay extends Payment {
    public String getPayName() {
        return "微信支付";
    }

    public double queryBalance(String uid) {
        return 260;
    }
}
