<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="../../js/jquery-1.8.3.js"></script>
</head>
<body>
<center>
    <h1>上报</h1>
    <form id="saveForm" action="${pageContext.request.contextPath}/deathstatistics/generator" enctype="multipart/form-data" method="post" modelAttribute="DeathStatistics">
        <table align="center" bgcolor="aqua" border="1" cellpadding="0">
            <tbody>
            <tr>
                <td>编码</td><td><input  type="text" value="${DeathStatistics.disasterID}" name="disasterID"/></td>
            </tr>
            <tr>
                <td>上报时间</td><td><input type="text" value="${DeathStatistics.disasterDate}" name="disasterDate"/></td>
            </tr>
            <tr>
                <td>地点</td><td><input type="text" value="${DeathStatistics.location}" name="location"/></td>
            </tr>
            <tr>
                <td>死亡人数</td><td><input type="number" value="${DeathStatistics.numberDeath}" name="numberDeath"/></td>
            </tr>
            <tr>
                <td>上报单位</td><td><input type="text" value="${DeathStatistics.reportingUnit}" name="reportingUnit"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交" /></td>
            </tr>
            </tbody>
        </table>
    </form>
</center>
</body>
</html>

