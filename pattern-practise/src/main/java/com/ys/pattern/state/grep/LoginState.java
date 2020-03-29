package com.ys.pattern.state.grep;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/19 12:29
 * @Version: 1.0
 */
public class LoginState extends UserState {
    public void favorite() {
        System.out.println("收藏成功");
    }

    public void comment(String str) {
        System.out.println("评论："+str);
    }
}
