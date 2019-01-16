package com.chen.web.hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
@Api(value = "测试", description = "测试")
public class HelloController {



    @ApiOperation( "测试")
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "曾经我也想过一了百了";
    }

}
