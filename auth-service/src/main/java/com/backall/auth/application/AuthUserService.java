package com.backall.auth.application;

import com.backall.auth.application.dto.AuthUserDTO;
import com.backall.auth.domain.user.AuthUserEO;
import com.backall.auth.domain.user.enums.AuthUserStatusEnum;
import com.backall.auth.domain.user.dao.AuthUserRepository;
import com.backall.auth.infrastructure.utility.Result;
import com.backall.auth.infrastructure.utility.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthUserService {

    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private SnowFlakeUtil snowFlakeUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;

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
