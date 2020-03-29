package com.ys.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/24 11:10
 * @Version: 1.0
 */
public class VoEvent {
    @Subscribe
    public void event(Vo o){
        System.out.println("执行了VoEvent的event方法");
    }
}
