package com.ys.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/24 11:13
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        PoJoEvent poJoEvent = new PoJoEvent();
        VoEvent voEvent = new VoEvent();

        eventBus.register(poJoEvent);
        eventBus.register(voEvent);

        PoJo poJo = new PoJo();

        eventBus.post(poJo);
    }
}
