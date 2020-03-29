package com.ys.pattern.chain.auth.buildChain;

import com.ys.pattern.chain.auth.Member;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 17:29
 * @Version: 1.0
 */
public class CheckUsernamePasswordHandler extends Handler {
    public void doHandler(Member member) {
        if(StringUtils.isEmpty(member.getLoginName()) ||
                StringUtils.isEmpty(member.getLoginPass())){
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");
        if(next != null)
            next.doHandler(member);
    }
}
