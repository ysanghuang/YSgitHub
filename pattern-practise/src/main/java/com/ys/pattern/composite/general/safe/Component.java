package com.ys.pattern.composite.general;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/4/2 9:58
 * @Version: 1.0
 */
public abstract class Component {
    protected String name;

    public Component(String name) {
        this.name = name;
    }

    public abstract String operate();
}
