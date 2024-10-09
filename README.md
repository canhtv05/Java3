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

---

```xml
<dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>12.8.1.jre11</version>
</dependency>
```

# Thư viện forEach

---

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
