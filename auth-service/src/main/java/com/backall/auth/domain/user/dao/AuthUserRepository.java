package com.backall.auth.domain.user.dao;

import com.backall.auth.domain.user.AuthUserEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUserEO, Long> {

    AuthUserEO findByUsername(String username);

}
