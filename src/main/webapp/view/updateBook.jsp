<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<%--    vì là đẩy dữ liệu nên là submit form--%>
<%--thêm method post--%>
<%--cái action tí sửa--%>
<form action="/book/update" method="post">
<%--    mé lỗi đâu r :v--%>
<%--     khi submit thi đưa nó tới đường dẫn add nó sẽ xử lý thêm book mới--%>
<%--     người dungf muốn khi bấm sửa thì nó phải hiện thị dữ liệu cũ nên mình vừa lấy dữ liệu của book khi bấm vào id
    bây giờ sử dụng  nó vào bằng cách input có value nên chèn value sẵn vào
    book  mình vừa setAttribute ko sua duojc id nen readonly
    --%>
    <table>
        <tr>
            <td><label for="id">ID</label></td>
            <td><input type="text" name="id" id="id" value="${book.id}" readonly></td>
        </tr>
        <tr>
            <td><label for="category">Category</label></td>
            <td><input type="text" name="category" id="category" value="${book.category}"></td>
        </tr>
        <tr>
            <td><label for="title">Title</label></td>
            <td><input type="text" name="title" id="title" value="${book.title}"></td>
        </tr>
        <tr>
            <td><label for="quantity">Quantity</label></td>
            <td><input type="text" name="quantity" id="quantity" value="${book.quantity}"></td>
        </tr>
        <tr>
            <td><button type="submit">Submit</button></td>
        </tr>
    </table>
</form>
</body>
</html>
