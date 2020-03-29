package com.ys.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/24 9:18
 * @Version: 1.0
 */
public class PoJoEvent {

    @Subscribe
    public void event(PoJo o){
        System.out.println("执行了PoJoEvent的event方法");
    }
}
