package com.springall.auth.repository;

import com.springall.auth.entity.AuthUserEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUserEO, Long> {

    AuthUserEO findByUsername(String username);

}
