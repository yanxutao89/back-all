package com.backall.msg.application.dto;

import com.backall.msg.domain.user.AuthUserEO;
import com.backall.msg.domain.user.validation.NotConflictUser;
import com.backall.msg.infrastructure.validation.Create;
import com.backall.msg.infrastructure.validation.Delete;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@NotConflictUser(groups = Create.class, message = "argument.not.conflict")
public class AuthUserDTO {

    @NotNull(groups = Delete.class, message = "argument.not.null")
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthUserEO toEO() {
        AuthUserEO eo = new AuthUserEO();
        eo.setUsername(this.getUsername());
        eo.setPassword(this.getPassword());
        return eo;
    }

}
