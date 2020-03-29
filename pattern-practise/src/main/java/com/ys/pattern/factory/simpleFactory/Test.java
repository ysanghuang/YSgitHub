package com.ys.pattern.factory.simpleFactory;

import javax.xml.stream.FactoryConfigurationError;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/22 14:44
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();
        ICourse course = factory.createCourse(JavaCourse.class);
        course.record();
    }
}
