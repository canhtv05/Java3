package jdbc;

import java.sql.*;

public class DatabaseConnect {
    private final String URL;

    public DatabaseConnect(String databaseName, String username, String password) {
        this.URL = "jdbc:sqlserver://localhost:1433;database=" + databaseName
                + ";user=" + username
                + ";password=" + password
                + ";encrypt=true;" + "trustServerCertificate=true;" + "loginTimeout=30;";
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Connection success");
        }

        return DriverManager.getConnection(this.URL);
    }

    public void closeConnection(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Connection closed");
    }

    public static void main(String[] args) {
        // sủa db name, username, password
        DatabaseConnect dcm = new DatabaseConnect("book", "sa", "123456");
        try {
            dcm.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}