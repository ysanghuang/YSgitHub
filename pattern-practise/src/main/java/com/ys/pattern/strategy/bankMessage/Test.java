package com.ys.pattern.strategy.bankMessage;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 19:51
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Message message = new Message();
        message.setCardId("6271 **** **** **** 12");
        message.setPhone("15951080000");
        message.setEmail("15951080000@163.com");
        message.setWeChatNum("15951080000");

        MessageService service = new MessageService(message);
        service.send();
        service.send(SendStrategy.PHONE);
        service.send(SendStrategy.EMAIL);
        service.send(SendStrategy.WECHAT);
    }
}
