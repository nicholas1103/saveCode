package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLData {
    private static String jdbcURL = "jdbc:mysql://admin.neosoft.vn:3306/kawhfhmf_NeoSQL";
    private static String username = "kawhfhmf_neo_user";
    private static String password = "NeoSQL2009!";

    // CREATE TABLE savePath(MSSV text, filePath text)
    public void insertData(String MSSV, String filePath){
        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "INSERT INTO savePath(MSSV, filePath) VALUES ('" + MSSV + "', '" + filePath + "')";
            System.out.println("Thêm thành công");
            statement.execute(sqlQuery);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
