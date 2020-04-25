package com.ys.pattern.composite.general;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/4/2 10:09
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Composite root = new Composite("root");

        Composite compositeA = new Composite("----compositeA");
        Composite compositeB = new Composite("--------compositeB");

        Component leafA = new Leaf("--------leafA");
        Component leafB = new Leaf("------------leafB");
        Component leafC = new Leaf("----leafC");

        root.addChild(compositeA);
        root.addChild(leafC);

        compositeA.addChild(compositeB);
        compositeA.addChild(leafA);

        compositeB.addChild(leafB);

        System.out.println(root.operate());
    }
}
