package com.ys.pattern.strategy.pay;

/**
 * @Author: yangshuang
 * @Description:
 * @Date: 2020/3/15 15:31
 * @Version: 1.0
 */
public class ResultMsg {
    private String code;
    private Object data;
    private String message;

    @Override
    public String toString() {
        return "ResultMsg{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public ResultMsg() {
    }

    public ResultMsg(String code, Object data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public ResultMsg(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
