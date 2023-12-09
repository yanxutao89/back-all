package com.backall.msg.application;

import com.backall.msg.application.dto.AuthUserDTO;
import com.backall.msg.domain.user.AuthUserEO;
import com.backall.msg.domain.user.enums.AuthUserStatusEnum;
import com.backall.msg.domain.user.dao.AuthUserRepository;
import com.backall.msg.infrastructure.utility.Result;
import com.backall.msg.infrastructure.utility.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthUserApplicationService {

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

    public Result deleteUser(AuthUserDTO authUserDTO) {
        Optional<AuthUserEO> authUserEO = authUserRepository.findById(authUserDTO.getId());
        authUserEO.ifPresent(eo -> authUserRepository.delete(eo));
        return Result.success(null, "操作成功");
    }

}
