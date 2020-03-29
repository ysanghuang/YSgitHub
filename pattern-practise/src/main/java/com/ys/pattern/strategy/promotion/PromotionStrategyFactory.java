package com.ys.pattern.strategy.promotion;

import com.sun.deploy.util.StringUtils;
import sun.invoke.empty.Empty;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 14:24
 * @Version: 1.0
 */
public class PromotionStrategyFactory {

    public static Map<String,IPromotionStrategy> strategy = new HashMap<String,IPromotionStrategy>();
    static {
        strategy.put(PromotionType.CASH_BACK,new CashbackStrategy());
        strategy.put(PromotionType.EMPTY,new EmptyStrategy());
        strategy.put(PromotionType.GROUP_BUY,new GroupbuyStrategy());
        strategy.put(PromotionType.COUPON,new CouponStrategy());
    }

    private PromotionStrategyFactory(){}

    public static IPromotionStrategy getPromotionStategy(String strategyKey){
        if (strategyKey == null || "".equals(strategyKey))
            strategyKey = PromotionType.EMPTY;
        IPromotionStrategy promotionStrategy = strategy.get(strategyKey);
        return promotionStrategy;
    }

    public static Set getStrategyKey(){
        return strategy.keySet();
    }

    private interface PromotionType{
        String CASH_BACK = "CASH_BACK";
        String EMPTY = "EMPTY";
        String GROUP_BUY = "GROUP_BUY";
        String COUPON = "COUPON";
    }
}
