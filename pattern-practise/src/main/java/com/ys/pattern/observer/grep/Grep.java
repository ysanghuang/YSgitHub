package com.ys.pattern.observer.grep;

import java.util.Observable;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/23 21:37
 * @Version: 1.0
 */
public class Grep extends Observable {
    private String name = "咕泡社区";
    private static final Grep grep = new Grep();

    private Grep(){};

    public static Grep getInstance(){
        return grep;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void publishQuestion(Question question){
        System.out.println(question.getUsername()+"在社区发表了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
