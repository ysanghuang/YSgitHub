package com.ys.pattern.factory.simpleFactory;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/22 14:38
 * @Version: 1.0
 */
public class PythonCourse implements ICourse {
    @Override
    public void record() {
        System.out.println("录制Python课程");
    }
}
