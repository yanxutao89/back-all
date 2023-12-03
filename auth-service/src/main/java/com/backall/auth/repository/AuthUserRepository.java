package com.backall.auth.repository;

import com.backall.auth.entity.AuthUserEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUserEO, Long> {

    AuthUserEO findByUsername(String username);

}
