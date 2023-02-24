package com.jsp.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@FunctionalInterface
public interface DBExtractor<T> {
    List<T> getList(ResultSet rs) throws SQLException;
}
