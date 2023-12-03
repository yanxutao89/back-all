package com.backall.auth.service.impl;

import com.backall.auth.dto.AuthUserDTO;
import com.backall.auth.entity.AuthUserEO;
import com.backall.auth.enums.AuthUserStatusEnum;
import com.backall.auth.repository.AuthUserRepository;
import com.backall.auth.service.AuthUserService;
import com.backall.auth.util.Result;
import com.backall.auth.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private SnowFlakeUtil snowFlakeUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Result createUser(AuthUserDTO authUserDTO) {
        AuthUserEO authUserEO = authUserDTO.toEO();
        authUserEO.setId(snowFlakeUtil.nextId());
        authUserEO.setPassword(passwordEncoder.encode(authUserEO.getPassword()));
        authUserEO.setCreateDate(new Date());
        authUserEO.setStatus(AuthUserStatusEnum.NORMAL.code());
        AuthUserEO save = authUserRepository.save(authUserEO);
        return save != null ? Result.success(save, "操作成功") : Result.failure("操作失败");
    }

}
