package com.backall.msg.domain.security;

import com.backall.msg.domain.user.AuthUserEO;
import com.backall.msg.domain.user.dao.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
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
            throw new BadCredentialsException("invalid username or password");
        }
        return new AuthUserDetails(authUserEO);
    }

}
