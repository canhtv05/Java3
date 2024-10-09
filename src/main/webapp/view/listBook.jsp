<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--import viện vào : )) ở github--%>
<html>
<head>
    <title>List Book</title>
</head>
<body>
<%--them border vao :V--%>
<%-- khi bấm vào thẻ a này nó sẽ sang value là cái href và nó lọt vào switch--%>
<a href="/book/read">Add new Book</a>
<table border="1">
    <tr>
        <th>#</th>
        <th>Id</th>
        <th>Category</th>
        <th>Title</th>
        <th>Quantity</th>
        <th colspan="3">Actions</th>
    </tr>
    <%--    sử dụng foreach để lặp mỗi phần tử của danh sách lấy từ db--%>
    <%--    var: mỗi lần lặp nó sẽ láy giá trị của books
            books là list book là object nên nó lặp thì lặp object book cũng như foreach bên java core thôi
            items: là cái mình vừa setAttribute với tên đó
            varStatus: là 1 phần của thư viện nó có count: đếm số lượng hiện tại, index, last, first,.. tự tìm hiểu
            nó dùng cú pháp lấy dữ liệu của biến như bên javascript gần giống
        --%>
    <%--    :v sai o day--%>
    <c:forEach var="book" items="${books}" varStatus="i">
        <tr>
            <td>${i.count}</td>
            <td>${book.id}</td>
            <td>${book.category}</td>
            <td>${book.title}</td>
            <td>${book.quantity}</td>
            <td>
                <a href="/book/edit?id=${book.id}">Edit</a>
                <span> </span>
                <a href="/book/delete?id=${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
