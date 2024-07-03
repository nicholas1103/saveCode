
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