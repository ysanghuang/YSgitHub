package com.ys.pattern.observer.grep;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/23 22:07
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Grep grep = Grep.getInstance();

        Teacher tom = new Teacher("Tom");
        Teacher jack = new Teacher("Jack");

        grep.addObserver(tom);
        grep.addObserver(jack);

        Question question = new Question("ys","SpringMVC核心原理？");
        grep.publishQuestion(question);
    }
}
