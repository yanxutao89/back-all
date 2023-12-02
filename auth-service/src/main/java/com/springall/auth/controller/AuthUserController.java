package com.springall.auth.controller;

import com.springall.auth.dto.AuthUserDTO;
import com.springall.auth.service.AuthUserService;
import com.springall.auth.util.Result;
import com.springall.auth.validation.Create;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping
    public Result createUser(@RequestBody @Validated(Create.class) AuthUserDTO authUserDTO) {
        return authUserService.createUser(authUserDTO);
    }

}
