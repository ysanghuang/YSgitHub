package com.ys.pattern.state.grep;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/19 12:27
 * @Version: 1.0
 */
public class AppContext {
    public final UserState LOGIN_STATE = new LoginState();
    public final UserState UNLOGIN_STATE = new UnLoginState();

    //默认未登录
    private UserState currentState = UNLOGIN_STATE;

    {
        LOGIN_STATE.setContext(this);
        UNLOGIN_STATE.setContext(this);
    }

    public UserState getUserState(){
        return this.currentState;
    }

    public void setUserState(UserState userState){
        this.currentState = userState;
    }

    public void favorite(){
        this.currentState.favorite();
    }

    public void comment(String str){
        this.currentState.comment(str);
    }
}
