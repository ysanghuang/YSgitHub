package com.ys.pattern.strategy.bankMessage;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 19:36
 * @Version: 1.0
 */
public class MessageService {
    Message message;

    public MessageService(Message message) {
        this.message = message;
    }

    public void send(){
        send(SendStrategy.DEFAULT);
    }

    public void send(String sendType){
        SendType send = SendStrategy.getSendType(sendType);
        send.send(message);
    }
}
