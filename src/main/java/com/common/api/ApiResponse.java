package com.common.api;

import com.common.exception.BusinessException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("api响应")
public class ApiResponse<T> implements IApiResponse{

    @ApiModelProperty("api响应状态")
    private int status;
    @ApiModelProperty("api异常信息")
    private String msg;
    @ApiModelProperty("返回体")
    private T body;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static <T> ApiResponse<T> success(T body) {
        ApiResponse<T> resp=new ApiResponse<T>();
        resp.setBody(body);
        return resp;
    }

    public static <T> ApiResponse error(int status,String msg){
        ApiResponse<T> resp=new ApiResponse<T>();
        resp.setStatus(status);
        resp.setMsg(msg);
        return  resp;
    }

    public static <T> ApiResponse<T> error(int status){
        return error(status,null);
    }


    @Override
    public void exception(BusinessException exception) {
        setStatus(exception.getStatus());
        setMsg(exception.getMessage());
    }

    @Override
    public String dataField() {
        return "body";
    }
}
