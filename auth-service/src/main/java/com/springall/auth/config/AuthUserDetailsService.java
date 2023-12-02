package com.springall.auth.config;

import com.springall.auth.entity.AuthUserEO;
import com.springall.auth.repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUserEO authUserEO = authUserRepository.findByUsername(username);
        if (authUserEO == null) {
            throw new RuntimeException("用户授权失败");
        }
        return new AuthUserDetails(authUserEO);
    }

}
