package com.gupaoedu.vip.pattern.adapter.general.classadapter;

/**
 * Created by Tom.
 */
public class Adapter extends Adaptee implements Target {
    public int request() {
        return super.specificRequest() / 10;
    }
}
