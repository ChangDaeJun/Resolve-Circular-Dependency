package com.jsp.biz.user;

import com.jsp.biz.DomainVO;
import com.jsp.database.DBExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserVO implements DomainVO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String role;
    private String joinDate;

    @Override
    public String toString() {
        return "UserVO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", joinDate='" + joinDate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    @Override
    public String[] getInsertValue(){
        String[] value = {this.email, this.password, this.name, this.role};
        return value;
    }

    @Override
    public String[] getUpdateValue(){
        String[] value = {this.name, this.role, ""+ this.id};
        return value;
    }

    @Override
    public String[] getDeleteValue(){
        String[] value = {""+ this.id};
        return value;
    }

    @Override
    public String[] getFindByIdValue(){
        String[] value = {""+ this.id};
        return value;
    }
}
