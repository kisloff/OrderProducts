<%--
  Created by IntelliJ IDEA.
  User: kv
  Date: 01.01.17
  Time: 8:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" import="java.io.*" contentType="text/plain"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

Message:
<%=exception.getMessage()%>

StackTrace:
<%
	StringWriter stringWriter = new StringWriter();
	PrintWriter printWriter = new PrintWriter(stringWriter);
	exception.printStackTrace(printWriter);
	System.out.println(stringWriter); //??? откуда печатать
	printWriter.close();
	stringWriter.close();
%>

</body>
</html>




