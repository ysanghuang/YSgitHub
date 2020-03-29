package com.ys.pattern.strategy.bankMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 19:42
 * @Version: 1.0
 */
public class SendStrategy {
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String WECHAT = "wechat";
    public static final String DEFAULT = PHONE;

    private static Map<String, SendType> strategy = new HashMap<String, SendType>();

    static {
        strategy.put(PHONE,new PhoneSend());
        strategy.put(EMAIL,new EmailSend());
        strategy.put(WECHAT,new WeChatSend());
    }

    public static SendType getSendType(String sendType){
        if(!strategy.containsKey(sendType)){
            throw new RuntimeException("暂不支持的消息方式");
        }
        return strategy.get(sendType);
    }
}
