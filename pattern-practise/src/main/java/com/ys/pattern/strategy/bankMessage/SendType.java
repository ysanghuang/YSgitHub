package com.ys.pattern.strategy.bankMessage;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 19:20
 * @Version: 1.0
 */
public interface SendType {
    void send(Message message);
}
