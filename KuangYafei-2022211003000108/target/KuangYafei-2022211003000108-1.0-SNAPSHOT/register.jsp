<%--
  Created by IntelliJ IDEA.
  User: 况亚飞
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/register"><!--within doPost() in servlet-->
    username <input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    Email<input type="text" name="email"/><br/>
    Gender<input type="radio" name="gender"value="male">Male <input type="radio" name="gender">Female<br/>
    Date of Birth :<input type="text name=" name="birthDate"><br/>
    <input type="submit" value="register"/>
</form>
</body>
</html>
