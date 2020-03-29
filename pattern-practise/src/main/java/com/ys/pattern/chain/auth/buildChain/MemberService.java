package com.ys.pattern.chain.auth.buildChain;

import com.ys.pattern.chain.auth.Member;

/**
 * Created by Tom.
 */
public class MemberService {
    public void login(Member member){
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new CheckUsernamePasswordHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());

        Handler handler = builder.build();
        handler.doHandler(member);

    }
}
