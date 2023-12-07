package com.backall.auth.domain.security;

import com.backall.auth.domain.user.AuthUserEO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthUserDetails implements UserDetails {

    private final AuthUserEO authUserEO;

    public AuthUserDetails(AuthUserEO authUserEO) {
        this.authUserEO = authUserEO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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
