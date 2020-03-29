package com.ys.pattern.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 15:04
 * @Version: 1.0
 */
public class PayStategy {
    public static final String ALIPAY = "AliPay";
    public static final String WECHAT_PAY = "WeChatPay";
    public static final String UNION_PAY = "unionPay";
    public static final String DEFAULT_PAY = ALIPAY;

    public static Map<String,Payment> payStategy = new HashMap<String, Payment>();

    static {
        payStategy.put(ALIPAY,new AliPay());
        payStategy.put(WECHAT_PAY,new WeChatPay());
        payStategy.put(UNION_PAY,new UnionPay());
    }

    public static Payment getPayStategy(String type) throws RuntimeException {
        if (!payStategy.containsKey(type)){
            throw new RuntimeException("暂不支持该支付方式："+type);
        }
        return payStategy.get(type);
    }
}
