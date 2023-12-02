package com.springall.auth.service;

import com.springall.auth.dto.AuthUserDTO;
import com.springall.auth.util.Result;

public interface AuthUserService {
    Result createUser(AuthUserDTO authUserDTO);

}
