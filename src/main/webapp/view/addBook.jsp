<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<%--    vì là đẩy dữ liệu nên là submit form--%>
<%--thêm method post--%>
<form action="/book/add" method="post">
<%--    mé lỗi đâu r :v--%>
<%--     khi submit thi đưa nó tới đường dẫn add nó sẽ xử lý thêm book mới--%>
    <table>
        <tr>
            <td><label for="id">ID</label></td>
            <td><input type="text" name="id" id="id"></td>
        </tr>
        <tr>
            <td><label for="category">Category</label></td>
            <td><input type="text" name="category" id="category"></td>
        </tr>
        <tr>
            <td><label for="title">Title</label></td>
            <td><input type="text" name="title" id="title"></td>
        </tr>
        <tr>
            <td><label for="quantity">Quantity</label></td>
            <td><input type="text" name="quantity" id="quantity"></td>
        </tr>
        <tr>
            <td><button type="submit">Submit</button></td>
        </tr>
    </table>
</form>
</body>
</html>
