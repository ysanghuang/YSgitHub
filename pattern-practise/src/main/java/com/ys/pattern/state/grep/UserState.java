package com.ys.pattern.state.grep;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/19 12:27
 * @Version: 1.0
 */
public abstract class UserState {
    protected AppContext context;

    public void setContext(AppContext context) {
        this.context = context;
    }

    public abstract void favorite();

    public abstract void comment(String str);
}
