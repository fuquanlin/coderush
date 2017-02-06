package cn.fql.coderush.base;

import java.sql.*;

/**
 * Created by fuquanlin on 2016/11/18.
 */
public class JDBCTest {
    public static void main(String[] args) throws Exception {
        Class.forName("");
        Connection connection = DriverManager.getConnection("");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }
    }
}
