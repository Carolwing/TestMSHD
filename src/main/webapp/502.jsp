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
    <form id="saveForm" action="${pageContext.request.contextPath}/disasterinfo/generator" enctype="multipart/form-data" method="post" modelAttribute="DisasterInfo">
        <table align="center" bgcolor="#E9F0FB" border="1" cellpadding="0">
            <tbody>
            <tr>
                <td>编码</td><td><input  type="text" value="${DisasterInfo.disasterID}" name="disasterID"/></td>
            </tr>
            <tr>
                <td>上报时间</td><td><input type="text" value="${DisasterInfo.disasterDate}" name="disasterDate"/></td>
            </tr>
            <tr>
                <td>地点</td><td><input type="text" value="${DisasterInfo.location}" name="location"/></td>
            </tr>
            <tr>
                <td>纬度</td><td><input type="number" step="0.000001" value="${DisasterInfo.latitude}" name="latitude"/></td>
            </tr>
            <tr>
                <td>经度</td><td><input type="number" step="0.000001" value="${DisasterInfo.longitude}" name="longitude"/></td>
            </tr>
            <tr>
                <td>深度</td><td><input type="number" step="0.01" value="${DisasterInfo.depth}" name="depth"/></td>
            </tr>
            <tr>
                <td>震级</td><td><input type="number" step="0.01" value="${DisasterInfo.magnitude}" name="magnitude"/></td>
            </tr>
            <tr>
                <td>烈度</td><td><input type="text" value="${DisasterInfo.intensity}" name="intensity"/></td>
            </tr>
            <tr>
                <td>上报单位</td><td><input type="text" value="${DisasterInfo.reportingUnit}" name="reportingUnit"/></td>
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

