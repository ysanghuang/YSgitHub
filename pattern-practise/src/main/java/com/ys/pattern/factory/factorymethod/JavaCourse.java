package com.ys.pattern.factory.factorymethod;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/22 14:38
 * @Version: 1.0
 */
public class JavaCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Java课程");
    }
}
