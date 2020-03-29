package com.ys.pattern.factory.simpleFactory;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/22 14:40
 * @Version: 1.0
 */
public class CourseFactory {
    public ICourse createCourse(Class<? extends ICourse> clazz){
        ICourse course;
        if (clazz != null){
            try {
                course = (ICourse)clazz.newInstance();
                return course;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
