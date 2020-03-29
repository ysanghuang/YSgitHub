package com.ys.pattern.strategy.bankMessage;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 19:28
 * @Version: 1.0
 */
public class WeChatSend implements SendType {
    public void send(Message message) {
        System.out.println("向微信号("+message.getWeChatNum()+")发送账户("+message.getCardId()+")的信息");
    }
}
