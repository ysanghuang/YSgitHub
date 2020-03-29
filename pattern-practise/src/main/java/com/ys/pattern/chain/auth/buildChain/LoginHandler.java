package com.ys.pattern.chain.auth.buildChain;

import com.ys.pattern.chain.auth.Member;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 17:35
 * @Version: 1.0
 */
public class LoginHandler extends Handler {
    public void doHandler(Member member) {
        if(null == member){
            System.out.println("用户不存在");
            return;
        }
        System.out.println("登录成功！");
        if(next != null)
            next.doHandler(member);
    }
}
