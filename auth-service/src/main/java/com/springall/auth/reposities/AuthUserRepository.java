package com.springall.auth.reposities;

import com.springall.auth.entities.AuthUserEO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUserEO, Long> {
}
