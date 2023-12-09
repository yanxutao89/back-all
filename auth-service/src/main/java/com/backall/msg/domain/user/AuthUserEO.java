package com.backall.msg.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

/**
 * 用户表
 */
@Entity(name = "auth_user")
public class AuthUserEO {
    @Id
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private Date createDate;
    private Date updateDate;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

}
