package com.ys.pattern.strategy.promotion;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 14:21
 * @Version: 1.0
 */
public class CouponStrategy implements IPromotionStrategy {
    public void doPromotion() {
        System.out.println("优惠券");
    }
}
