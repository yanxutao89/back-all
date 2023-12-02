package com.springall.auth.controller;

import com.springall.auth.util.Result;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Yanxt7
 * @Desc:
 * @Date: 2022/1/8 13:54
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @ResponseBody
    @PostMapping("")
    public Result loginProcess() {
        return Result.success(null, "login");
    }

    @ResponseBody
    @PostMapping("/success")
    public Result loginSuccess() {
        return Result.success(null, "login success");
    }

    @ResponseBody
    @PostMapping("/failure")
    public Result loginFailure() {
        return Result.success(null, "login failure");
    }

}
