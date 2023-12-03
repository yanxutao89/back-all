package com.backall.auth.controller;

import com.backall.auth.dto.AuthUserDTO;
import com.backall.auth.service.AuthUserService;
import com.backall.auth.util.Result;
import com.backall.auth.validation.Create;
import com.backall.auth.validation.NotConflictUser;
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
    public Result createUser(@RequestBody @Validated(Create.class) @NotConflictUser AuthUserDTO authUserDTO) {
        return authUserService.createUser(authUserDTO);
    }

}
