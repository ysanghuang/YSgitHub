package com.ys.pattern.singleton.register;

/**
 * Created by Tom.
 *
 * 1、序列化无法破坏枚举式单例，因为枚举类型其实通过类名和类对象类找到一个唯一的枚举对象。因此，枚举对象不可能被
 * 类加载器加载多次
 * 2、java不允许通过反射创建枚举类型
 */
public enum EnumSingleton {
    INSTANCE;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static EnumSingleton getInstance(){return INSTANCE;}
}
