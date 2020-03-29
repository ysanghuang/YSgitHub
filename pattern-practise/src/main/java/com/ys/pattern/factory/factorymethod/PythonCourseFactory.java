package com.ys.pattern.factory.factorymethod;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/22 14:55
 * @Version: 1.0
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
