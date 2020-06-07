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
    <form id="saveForm" action="${pageContext.request.contextPath}/masonrystructure/generator" enctype="multipart/form-data" method="post" modelAttribute="MasonryStructure">
        <table align="center" bgcolor="#E9F0FB" border="1" cellpadding="0">
            <tbody>
            <tr>
                <td>编码</td><td><input  type="text" value="${MasonryStructure.disasterID}" name="disasterID"/></td>
            </tr>
            <tr>
                <td>上报时间</td><td><input type="text" value="${MasonryStructure.disasterDate}" name="disasterDate"/></td>
            </tr>
            <tr>
                <td>地点</td><td><input type="text" value="${MasonryStructure.location}" name="location"/></td>
            </tr>
            <tr>
                <td>基本完好面积</td><td><input type="text" value="${MasonryStructure.intactSquare}" name="intactSquare"/></td>
            </tr>
            <tr>
                <td>轻微破坏面积</td><td><input type="text" value="${MasonryStructure.slightDamagedSquare}" name="damagedSquare"/></td>
            </tr>
            <tr>
                <td>中等破坏面积</td><td><input type="text" value="${MasonryStructure.moderateDamagedSquare}" name="damagedSquare"/></td>
            </tr>
            <tr>
                <td>严重破坏面积</td><td><input type="text" value="${MasonryStructure.seriousDamagedSquare}" name="damagedSquare"/></td>
            </tr>
            <tr>
                <td>毁坏面积</td><td><input type="text" value="${MasonryStructure.destroyedSquare}" name="destroyedSquare"/></td>
            </tr>
            <tr>
                <td>灾情描述</td><td><input type="text" value="${MasonryStructure.note}" name="note"/></td>
            </tr>
            <tr>
                <td>上报单位</td><td><input type="text" value="${MasonryStructure.reportingUnit}" name="reportingUnit"/></td>
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

