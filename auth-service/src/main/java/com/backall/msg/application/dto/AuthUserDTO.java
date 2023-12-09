package com.backall.msg.application.dto;

import com.backall.msg.domain.user.AuthUserEO;
import com.backall.msg.domain.user.validation.NotConflictUser;
import com.backall.msg.infrastructure.validation.Create;
import jakarta.validation.constraints.NotEmpty;

@NotConflictUser(groups = Create.class, message = "argument.conflict")
public class AuthUserDTO {

    @NotEmpty(groups = Create.class, message = "argument.empty")
    private String username;
    @NotEmpty(groups = Create.class, message = "argument.empty")
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
