package com.backall.msg.domain.user.dao;

import com.backall.msg.domain.user.AuthUserEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUserEO, Long> {

    AuthUserEO findByUsername(String username);

}
