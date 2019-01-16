package com.chen.web.login;


import com.chen.entity.po.User;
import com.chen.entity.qo.login.LoginDto;
import com.chen.service.UserService;
import com.common.api.ApiResponse;
import com.common.exception.BusincessExceptionCode;
import com.common.exception.BusinessException;
import com.common.util.MD5Utils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@RestController
@RequestMapping("/login")
public class loginController {

    @Autowired
    private UserService userService;

    @ApiOperation("登陆")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
   // public ApiResponse<String> login(@ApiParam("登陆参数") @RequestBody @Valid LoginDto dto, BindingResult result){
    public ApiResponse<String> login(@ApiParam("登陆参数") @RequestParam("userName")String userName, @RequestParam("password") String password){
        UsernamePasswordToken  token =new UsernamePasswordToken (userName,password);
        Subject subject=SecurityUtils.getSubject();
        try{
            subject.login(token);
            //根据权限，指定返回数据
            String role = userService.queryUserByName(userName).getRole();
            if ("user".equals(role)) {
                return ApiResponse.success("欢迎登陆");
            }
            if ("admin".equals(role)) {
                return ApiResponse.success("欢迎来到管理员页面");
            }



            return ApiResponse.success("登陆成功");
        }catch (AuthenticationException e){
            throw new BusinessException(BusincessExceptionCode.NON_EXISTENT,"登陆失败");
        }

    }

    @ApiOperation("登陆")
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public ApiResponse<String> logout(){
        Subject subject=SecurityUtils.getSubject();
        subject.logout();

        return ApiResponse.success("退出成功");
    }




}
