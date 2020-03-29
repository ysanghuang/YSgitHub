package com.ys.pattern.observer.grep;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/23 21:45
 * @Version: 1.0
 */
public class Question {
    private String username;
    private String content;

    public Question(String username, String content) {
        this.username = username;
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
