package com.backall.auth.service;

import com.backall.auth.util.Result;
import com.backall.auth.dto.AuthUserDTO;

public interface AuthUserService {
    Result createUser(AuthUserDTO authUserDTO);

}
