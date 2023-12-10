package com.backall.msg.domain.security;

import com.backall.msg.domain.user.AuthUserEO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class AuthUserDetails implements UserDetails {

    private final AuthUserEO authUserEO;

    public AuthUserDetails(AuthUserEO authUserEO) {
        this.authUserEO = authUserEO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("READ"));
    }

    @Override
    public String getPassword() {
        return authUserEO.getPassword();
    }

    @Override
    public String getUsername() {
        return authUserEO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled();
    }

    @Override
    public boolean isEnabled() {
        return authUserEO.getStatus() > 0;
    }

}
