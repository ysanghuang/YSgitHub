package com.ys.pattern.chain.auth.optimize;

import com.ys.pattern.chain.auth.Member;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Tom.
 */
public class MemberService {
    public void login(Member member){
        CheckUsernamePasswordHandler checkHandler = new CheckUsernamePasswordHandler();
        LoginHandler loginHandler = new LoginHandler();
        AuthHandler authHandler = new AuthHandler();

        checkHandler.next(loginHandler);
        loginHandler.next(authHandler);

        checkHandler.doHandler(member);
    }
}
