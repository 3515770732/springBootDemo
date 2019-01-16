package com.common.exception;

public class BusinessException extends  RuntimeException{

    private static final long serialVersionUID = -6118010137349240796L;

    //-1:系统异常 -2：token异常 -100:登录
    private int status;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(int status,String message) {
        super(message);
        this.status = status;
    }

    public BusinessException(IExpMessage expMessage) {
        this(expMessage.getStatus(),expMessage.getMessage());
    }

    public  BusinessException(String message,Exception e){
        super(message,e);
    }

    public BusinessException(int status,String message,Exception e){
        super(message,e);
        this.status=status;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
