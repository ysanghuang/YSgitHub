package com.ys.pattern.strategy.promotion;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 14:21
 * @Version: 1.0
 */
public class GroupbuyStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("团购");
    }
}
