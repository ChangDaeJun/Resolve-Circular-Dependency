package com.jsp.biz.user;

import com.jsp.biz.DomainVO;
import lombok.Data;

import java.util.Date;

@Data
public class UserVO implements DomainVO {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String role;
    private Date joinDate;

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

    public String[] getFindByEmailValue(){
        String[] value = {""+ this.email};
        return value;
    }
}
