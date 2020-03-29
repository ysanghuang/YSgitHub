package com.ys.pattern.factory.abstractfactory.factory;

import com.ys.pattern.factory.abstractfactory.factory.CourseFactory;
import com.ys.pattern.factory.abstractfactory.factory.JavaCourseFactory;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/22 15:09
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory factory = new JavaCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();

        factory = new PythonCourseFactory();
        factory.createNote().edit();
        factory.createVideo().record();
    }
}
