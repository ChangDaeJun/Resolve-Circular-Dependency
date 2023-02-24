package com.jsp.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DBController {

    private static void execute(String query, String... args){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(query);
            for(int i = 1 ; i <= args.length; i++){
                stmt.setString(i, args[i - 1]);
            }

            stmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(stmt, conn);
        }
    }

    public static void insert(String query, String... args){
        execute(query, args);
    }
    public static void update(String query, String... args){
        execute(query, args);
    }
    public static void delete(String query, String... args){
        execute(query, args);
    }
    public static List select(String query, DBExtractor function , String... args){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<?> list = null;

        try {
            conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(query);

            for(int i = 1 ; i <= args.length; i++){
                stmt.setString(i, args[i - 1]);
            }

            rs = stmt.executeQuery();
            list = function.getList(rs);

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.close(rs, stmt, conn);
        }

        return list;
    }
}
