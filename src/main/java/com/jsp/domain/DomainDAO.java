package com.jsp.domain;

import com.jsp.database.DBExtractor;

import java.util.List;

 public interface DomainDAO<T extends DomainVO> {
     List<T> getList();
     void insert(T vo);
     void update(T vo);
     void delete(T vo);
     T findById(T vo);
     DBExtractor<T> getAllExtractor();
}
