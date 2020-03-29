package com.ys.pattern.factory.abstractfactory.factory;

import com.ys.pattern.factory.abstractfactory.INote;
import com.ys.pattern.factory.abstractfactory.IVideo;

/**
 * 抽象工厂是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 * 易于扩展
 * Created by Tom.
 */
public abstract class CourseFactory {

    public void init(){
        System.out.println("初始化基础数据");
    }

    protected abstract INote createNote();

    protected abstract IVideo createVideo();

}
