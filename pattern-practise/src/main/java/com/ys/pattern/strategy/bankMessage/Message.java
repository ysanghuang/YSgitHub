package com.ys.pattern.strategy.bankMessage;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 19:22
 * @Version: 1.0
 */
public class Message {
    private String cardId;
    private String context;
    private String phone;
    private String weChatNum;
    private String email;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWeChatNum() {
        return weChatNum;
    }

    public void setWeChatNum(String weChatNum) {
        this.weChatNum = weChatNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
