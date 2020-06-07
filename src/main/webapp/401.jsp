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
    <h1><font color=#E9F0FB>上报</font></h1>
    <form id="saveForm" action="${pageContext.request.contextPath}/landsliderecord/generator" enctype="multipart/form-data" method="post" modelAttribute="LandslideRecord">
        <table align="center" bgcolor="#E9F0FB" border="1" cellpadding="0">
            <tbody>
            <tr>
                <td>编码</td><td><input  type="text" value="${LandslideRecord.disasterID}" name="disasterID"/></td>
            </tr>
            <tr>
                <td>上报时间</td><td><input type="text" value="${LandslideRecord.disasterDate}" name="disasterDate"/></td>
            </tr>
            <tr>
                <td>地点</td><td><input type="text" value="${LandslideRecord.location}" name="location"/></td>
            </tr>
            <tr>
                <td>类型</td><td><input type="text" value="${LandslideRecord.disasterType}" name="disasterType"/></td>
            </tr>
            <tr>
                <td>灾害程度</td><td><input type="text" value="${LandslideRecord.status}" name="status"/></td>
            </tr>
            <tr>
                <td>灾情描述</td><td><input type="text" value="${LandslideRecord.note}" name="note"/></td>
            </tr>
            <tr>
                <td>上报单位</td><td><input type="text" value="${LandslideRecord.reportingUnit}" name="reportingUnit"/></td>
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

