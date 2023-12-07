package com.backall.auth.resource;

import com.backall.auth.application.AuthUserApplicationService;
import com.backall.auth.application.dto.AuthUserDTO;
import com.backall.auth.infrastructure.utility.Result;
import com.backall.auth.infrastructure.validation.Create;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class AuthUserResource {

    @Autowired
    private AuthUserApplicationService authUserApplicationService;

    @PostMapping
    public Result createUser(@RequestBody @Validated(Create.class) AuthUserDTO authUserDTO) {
        return authUserApplicationService.createUser(authUserDTO);
    }

}
