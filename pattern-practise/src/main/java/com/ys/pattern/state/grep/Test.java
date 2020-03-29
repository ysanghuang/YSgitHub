package com.ys.pattern.state.grep;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/19 12:44
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        AppContext context = new AppContext();
//        context.setUserState(context.LOGIN_STATE);
        context.favorite();
        context.comment("宝贝已收到，很喜欢！");
    }
}
