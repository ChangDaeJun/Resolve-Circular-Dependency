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
        String[] value = {""+this.userId, ""+this.boardId};
        return value;
    }

    @Override
    public String[] getUpdateValue() {
        String[] value = {};
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
