package com.ys.pattern.chain.auth.buildChain;

import com.ys.pattern.chain.auth.Member;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 17:25
 * @Version: 1.0
 */
public abstract class Handler {
    protected Handler next;

    private void next(Handler next){
        this.next = next;
    }

    public abstract void doHandler(Member member);

    public static class Builder{
        Handler header;
        Handler tail;

        public Builder addHandler(Handler handler){
            if(header == null){
                header = handler;
                tail =handler;
            }
            tail.next = handler;
            tail = handler;
            return this;
        }

        public Handler build(){
            return this.header;
        }

    }
}
