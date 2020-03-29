package com.ys.pattern.strategy.promotion;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 14:32
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        PromotionStrategyFactory.getStrategyKey();

        IPromotionStrategy strategy = PromotionStrategyFactory.getPromotionStategy("COUPON");
        strategy.doPromotion();
    }
}
