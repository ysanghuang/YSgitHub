package com.ys.pattern.chain.auth.optimize;

import com.ys.pattern.chain.auth.Member;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 17:36
 * @Version: 1.0
 */
public class AuthHandler extends Handler {

    public void doHandler(Member member) {
        if(!"管理员".equals(member.getRoleName())){
            System.out.println("您不是管理员，没有操作权限");
            return;
        }
        System.out.println("允许操作");
        if(next != null)
            next.doHandler(member);
    }
}
