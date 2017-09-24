package com.taomei.web.share.data;

import lombok.Getter;
import lombok.Setter;


public class ResultView {
    private Integer code;
    private String message;
    private Object data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }
}
