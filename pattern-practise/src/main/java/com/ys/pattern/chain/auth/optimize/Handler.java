package com.ys.pattern.chain.auth.optimize;

import com.ys.pattern.chain.auth.Member;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 17:25
 * @Version: 1.0
 */
public abstract class Handler {
    protected Handler next;

    public void next(Handler next){
        this.next = next;
    }

    public abstract void doHandler(Member member);
}
