package com.chen.entity.po;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户")
public class User {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("员工名称")
    private String employeeName;
    @ApiModelProperty("是否在职 1：在职 0：离职")
    private Integer isWorking;

    @ApiModelProperty("登陆名")
    private String userName;
    @ApiModelProperty("登陆密码")
    private String password;

    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("对应组织架构id")
    private Integer departmentID;
    @ApiModelProperty("角色")
    private String role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(Integer isWorking) {
        this.isWorking = isWorking;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
