package com.chen.web.hello;

import com.common.api.ApiResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
@Api(value = "管理员模式", description = "管理员模式")
public class AdminController {

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ApiResponse<String> login() {
        return ApiResponse.success("欢迎进入，您的身份是管理员");
    }


    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ApiResponse<String> submitLogin() {
        return ApiResponse.success("您拥有管理员权限，可以获得该接口的信息！");
    }

}
