package com.jsp.biz.board;

import com.jsp.biz.DomainVO;
import lombok.Data;

import java.util.Date;

@Data
public class BoardVO implements DomainVO {
    private Long id;
    private Long userId;
    private String title;
    private String text;
    private String role;
    private Long viewCnt;
    private Date createdDate;

    @Override
    public String[] getInsertValue() {
        return new String[0];
    }

    @Override
    public String[] getUpdateValue() {
        return new String[0];
    }

    @Override
    public String[] getDeleteValue() {
        return new String[0];
    }

    @Override
    public String[] getFindByIdValue() {
        return new String[0];
    }
}
