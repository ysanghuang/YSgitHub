package com.ys.pattern.observer.grep;

import java.util.Observable;
import java.util.Observer;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/23 21:41
 * @Version: 1.0
 */
public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        Grep grep = (Grep) o;
        Question question = (Question)arg;
        System.out.println(name + "老师，你好！\n" +
                "您收到了一个来自" + grep.getName() + "的提问，希望您解答。问题内容如下：\n" +
                question.getContent() + "\n" +
                "提问者：" + question.getUsername());
    }
}
