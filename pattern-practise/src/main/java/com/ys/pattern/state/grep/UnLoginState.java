package com.ys.pattern.state.grep;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/19 12:29
 * @Version: 1.0
 */
public class UnLoginState extends UserState {
    public void favorite() {
        System.out.println("未登录状态");
        switch2Login();
        this.context.favorite();
    }

    public void comment(String str) {
        System.out.println("未登录状态");
        switch2Login();
        this.context.comment(str);
    }

    private void switch2Login(){
        System.out.println("切换到登录状态");
        this.context.setUserState(this.context.LOGIN_STATE);
    }
}
