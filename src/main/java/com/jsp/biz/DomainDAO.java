package com.jsp.biz;

import com.jsp.biz.user.UserVO;
import com.jsp.database.DBExtractor;

import java.util.List;

 public interface DomainDAO {
     List<UserVO> getList();
     void insert(UserVO userVO);
     void update(UserVO userVO);
     void delete(UserVO userVO);
     UserVO findById(UserVO userVO);
     DBExtractor<UserVO> getAllExtractor();
}
