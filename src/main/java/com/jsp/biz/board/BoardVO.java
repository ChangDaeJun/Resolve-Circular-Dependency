package com.jsp.biz.board;

import com.jsp.biz.DomainVO;
import lombok.Data;

import java.util.Date;

@Data
public class BoardVO implements DomainVO {
    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String text;
    private String role;
    private Long viewCnt;
    private Date createdDate;

    @Override
    public String[] getInsertValue() {
        String[] value = {""+this.userId, ""+this.title, this.text, this.role, ""+this.viewCnt};
        return value;
    }

    @Override
    public String[] getUpdateValue() {
        String[] value = {this.title, this.text, ""+this.viewCnt, ""+this.id};
        return value;
    }

    @Override
    public String[] getDeleteValue() {
        String[] value = {""+this.id};
        return value;
    }

    @Override
    public String[] getFindByIdValue() {
        String[] value = {""+this.id};
        return value;
    }
}
