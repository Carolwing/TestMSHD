<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2017/4/24
  Time: 上午12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<h1>您已经成功添加了数据到数据库中！</h1>
<c:out value="${CommDisaster.location}"></c:out>
<a href="../index.jsp">继续添加</a>
</center>
</body>
</html>