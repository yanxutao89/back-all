package com.backall.msg.resource;

import com.backall.msg.application.AuthUserApplicationService;
import com.backall.msg.application.dto.AuthUserDTO;
import com.backall.msg.infrastructure.utility.Result;
import com.backall.msg.infrastructure.validation.Create;
import com.backall.msg.infrastructure.validation.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AuthUserResource {

    @Autowired
    private AuthUserApplicationService authUserApplicationService;

    @PostMapping
    public Result createUser(@RequestBody @Validated(Create.class) AuthUserDTO authUserDTO) {
        return authUserApplicationService.createUser(authUserDTO);
    }

    @DeleteMapping("")
    public Result deleteUser(@RequestBody @Validated(Delete.class) AuthUserDTO authUserDTO) {
        return authUserApplicationService.deleteUser(authUserDTO);
    }

}
