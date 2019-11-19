package edu.nf.hansen.controller.vo;

/**
 * @author Achine
 * @date 2019/11/14
 */
public class ResponseVO<T> {
    private Integer code;
    private Object message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
