<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-1.8.3.js"></script>
</head>
<body>
<div style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">
    <img src="img/background.png" height="100%" width="100%" style="left:0; top:0;">
</div>
<center>
    <h1><font color=#E9F0FB>上报</font> </h1>
    <form id="saveForm" action="${pageContext.request.contextPath}/missingstatistics/generator" enctype="multipart/form-data" method="post" modelAttribute="MissingStatistics" >
        <table align="center" bgcolor="#E9F0FB" border="1" cellpadding="0">
            <tbody>
            <tr>
                <td>编码</td><td><input  type="text" value="${MissingStatistics.disasterID}" name="disasterID"/></td>
            </tr>
            <tr>
                <td>上报时间</td><td><input type="text" value="${MissingStatistics.disasterDate}" name="disasterDate"/></td>
            </tr>
            <tr>
                <td>地点</td><td><input type="text" value="${MissingStatistics.location}" name="location"/></td>
            </tr>
            <tr>
                <td>死亡人数</td><td><input type="number" value="${MissingStatistics.numberDeath}" name="numberDeath"/></td>
            </tr>
            <tr>
                <td>上报单位</td><td><input type="text" value="${MissingStatistics.reportingUnit}" name="reportingUnit"/></td>
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

