# Template settings
1. Step 1: File -> Settings -> Editor -> File and Code templates
2. Step 2: Click Add new Template (icon `+`)
3. Step 3: Name: Servlet
4. Step 4: Copy here 👉
5. Step 5: Click Apply -> OK and enjoy ✅

# 1. Servlet Template
```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "${Class_Name}", value = "/${Class_Name}")
public class ${Class_Name} extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
```

# 2. DatabaseConnectionManager

```java
#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import java.sql.*;

public class ${Class_Name} {
    private final String URL;

    public ${Class_Name}(String databaseName, String username, String password) {
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
}
```

# DB
```sql
CREATE DATABASE book;
GO
USE book;
GO

CREATE TABLE Book(
	id INT PRIMARY KEY identity,
	category varchar(100),
	title varchar(100),
	quantity int
);

```

# Lệnh import forEach

```jsp
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

# Thư viện jdbc

```xml
<dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>12.8.1.jre11</version>
</dependency>
```

# Thư viện forEach

```xml
<dependency>
    <groupId>org.glassfish.web</groupId>
    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
    <version>3.0.1</version>
</dependency>

<dependency>
    <groupId>jakarta.servlet.jsp.jstl</groupId>
    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
    <version>3.0.0</version>
</dependency>
```
