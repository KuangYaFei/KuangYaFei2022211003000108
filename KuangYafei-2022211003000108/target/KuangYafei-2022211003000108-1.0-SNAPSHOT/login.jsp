<%--
  Created by IntelliJ IDEA.
  User: 况亚飞
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<h1>Login</h1>
<body>
<form method="post" action="${pageContext.request.contextPath}/login"><!--within doPost() in servlet-->
    username <input type="text" name="username"/><br/>
    password <input type="password" name="password"/><br/>

    <input type="submit" value="Login"/>

</form>
</body>
</html>
<%@include file="footer.jsp"%>
