package com.ys.pattern.factory.factorymethod;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/22 14:57
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ICourseFactory factory = new JavaCourseFactory();
        ICourse course = factory.create();
        course.record();

        factory = new PythonCourseFactory();
        course = factory.create();
        course.record();
    }
}
