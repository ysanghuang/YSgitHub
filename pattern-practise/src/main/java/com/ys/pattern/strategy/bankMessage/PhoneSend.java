package com.ys.pattern.strategy.bankMessage;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 19:28
 * @Version: 1.0
 */
public class PhoneSend implements SendType {
    public void send(Message message) {
        System.out.println("向手机号("+message.getPhone()+")发送账户("+message.getCardId()+")的信息");
    }
}
