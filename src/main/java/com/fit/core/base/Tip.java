package com.fit.core.base;

/**
 * @className: Tip
 * @description: 返回提示
 * @author: Aim
 * @date: 2023/3/29
 **/
public abstract class Tip {

    protected int code;
    protected String message;
    protected Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
