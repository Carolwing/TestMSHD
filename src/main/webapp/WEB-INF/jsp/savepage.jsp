<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上报灾情</title>
</head>
<body>
<br/>
<form id="saveForm" action="${pageContext.request.contextPath}/disaster/generator" method="post">
    <table  align="center" bgcolor="aqua" border="1" cellpadding="0">
        <tbody>
        <tr>
            <td>ID</td><td><input  id="id" type="text"></td>
        </tr>
        <tr>
            <td>上报时间</td><td><input id="date" type="text"></td>
        </tr>
        <tr>
            <td>地点</td><td><input id="location" type="text"></td>
        </tr>
        <tr>
            <td>类型</td><td><input id="type" type="text"></td>
        </tr>
        <tr>
            <td>破坏等级</td><td><input id="grade" type="text"></td>
        </tr>
        <tr>
            <td>灾情描述</td><td><input id="note" type="text"></td>
        </tr>
        <tr>
            <td>上报单位</td><td><input id="reportingUnit" type="text"></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input onclick="insertNews()" type="button" value="提交"></td>
        </tr>
        </tbody>
        <input type="submit" value="添加" />
    </table>
</form>
</body>
</html>
