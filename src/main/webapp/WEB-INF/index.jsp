<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: kv
  Date: 23.12.16
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Просмотр продуктов</title>
  </head>
  <body>
  <form action="../autorisation.jsp">
    <input type="submit" value="Авторизация">
  </form>

  <%--<table border="1" cellpadding="8" cellspacing="0">--%>
    <%--<thead>--%>
    <%--<tr>--%>
      <%--<th>id</th>--%>
      <%--<th>name</th>--%>
      <%--<th>address</th>--%>
      <%--<th>phone</th>--%>
    <%--</tr>--%>
    <%--</thead>--%>

  <%--<c:forEach items="${users}" var="user">--%>
    <%--<jsp:useBean id="user" scope="page" type="ru.kkiselev.model.POJO.User"/>--%>
    <%--<tr>--%>
      <%--<td>${user.id}</td>--%>
      <%--<td>${user.name}</td>--%>
      <%--<td>${user.address}</td>--%>
      <%--<td>${user.phone_number}</td>--%>
    <%--</tr>--%>
  <%--</c:forEach>--%>
    <%--</table>--%>

  <table border="1" cellpadding="8" cellspacing="0">
      <thead>
      <tr>
          <th>id</th>
          <th>name</th>
          <th>description</th>
          <th>price</th>
          <th>quantity</th>
          <th>purchase</th>
      </tr>
      </thead>

      <c:forEach items="${products}" var="product">
          <jsp:useBean id="product" scope="page" type="ru.kkiselev.model.POJO.Product"/>
          <tr>
              <td>${product.id}</td>
              <td>${product.name}</td>
              <td>${product.description}</td>
              <td>${product.price}</td>
              <td><input type="number" name = "inputNumber" min="1" max="100"></td>
              <td><input type="checkbox" name = "myCheckbox"></td>
          </tr>
      </c:forEach>
  </table>

  <form action="../buy.jsp">
      <input type="submit" value="Перейти в корзину">

  </form>

  </body>
</html>
