package com.springall.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("")
    public String login() {
        return "login";
    }

    @ResponseBody
    @GetMapping("/success")
    public String loginSuccess() {
        return "login success";
    }

    @ResponseBody
    @GetMapping("/failure")
    public String loginFailure() {
        return "login failure";
    }

}
