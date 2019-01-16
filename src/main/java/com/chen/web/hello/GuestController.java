package com.chen.web.hello;


import com.common.api.ApiResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/guest")
@Api(value = "游客模式", description = "游客模式")
public class GuestController {

    @RequestMapping(value = "/enter", method = RequestMethod.GET)
    public ApiResponse<String> login() {
        return ApiResponse.success("欢迎进入，您的身份是游客");
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ApiResponse<String> submitLogin() {
        return ApiResponse.success("您拥有获得该接口的信息的权限！");
    }


}
