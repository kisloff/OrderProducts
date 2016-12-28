<%@ page import="ru.kkiselev.model.POJO.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: kv
  Date: 23.12.16
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

${products}

<%
    List<Product> lp = (List<Product>)request.getAttribute ("products")
%>






<form action="admin.jsp" method="get" target="_blank">
    Логин: <input type="text" name="login"><br>
    Пароль: <input type="password" name="password"><br>
    <input type="submit" value="Войти">
</form>
</body>
</html>
