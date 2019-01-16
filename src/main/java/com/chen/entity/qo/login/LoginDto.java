package com.chen.entity.qo.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

@ApiModel("登陆请求参数")
public class LoginDto {

    @NotBlank(message = "登陆名称不能为空")
    @ApiModelProperty("登陆名称")
    private String userName;

    @NotBlank(message = "登陆密码不能为空")
    @ApiModelProperty("登陆密码")
    private String password;

    @ApiModelProperty("是否记住密码")
    private String loginRememb;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginRememb() {
        return loginRememb;
    }

    public void setLoginRememb(String loginRememb) {
        this.loginRememb = loginRememb;
    }
}
