package com.jsp.biz.like;

import com.jsp.biz.DomainVO;
import lombok.Data;

import java.util.Date;

@Data
public class LikeVO implements DomainVO {
    private Long id;
    private Long userId;
    private Long boardId;
    private Date likedDate;

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
