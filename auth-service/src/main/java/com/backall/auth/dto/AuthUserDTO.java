package com.backall.auth.dto;

import com.backall.auth.entity.AuthUserEO;
import com.backall.auth.validation.Create;
import jakarta.validation.constraints.NotEmpty;

public class AuthUserDTO {

    @NotEmpty(groups = Create.class, message = "argument.not.empty")
    private String username;
    @NotEmpty(groups = Create.class, message = "argument.not.empty")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthUserEO toEO() {
        AuthUserEO eo = new AuthUserEO();
        eo.setUsername(this.getUsername());
        eo.setPassword(this.getPassword());
        return eo;
    }

}
