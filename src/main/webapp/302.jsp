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
    <form id="saveForm" action="${pageContext.request.contextPath}/trafficdisaster/generator" enctype="multipart/form-data" method="post" modelAttribute="TrafficDisaster">
        <table align="center" bgcolor="#E9F0FB" border="1" cellpadding="0">
            <tbody>
            <tr>
                <td>编码</td><td><input  type="text" value="${TrafficDisaster.disasterID}" name="disasterID"/></td>
            </tr>
            <tr>
                <td>上报时间</td><td><input type="text" value="${TrafficDisaster.disasterDate}" name="disasterDate"/></td>
            </tr>
            <tr>
                <td>地点</td><td><input type="text" value="${TrafficDisaster.location}" name="location"/></td>
            </tr>
            <tr>
                <td>类型</td><td><input type="text" value="${TrafficDisaster.disasterType}" name="disasterType"/></td>
            </tr>
            <tr>
                <td>破坏等级</td><td><input type="text" value="${TrafficDisaster.grade}" name="grade"/></td>
            </tr>
            <tr>
                <td>灾情描述</td><td><input type="text" value="${TrafficDisaster.note}" name="note"/></td>
            </tr>
            <tr>
                <td>上报单位</td><td><input type="text" value="${TrafficDisaster.reportingUnit}" name="reportingUnit"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交" /></td>
            </tr>
            </tbody>
        </table>
    </form>
</center>
<%--<script>--%>
<%--    //添加按钮--%>
<%--    function insertNews() {--%>
<%--        var idCommDisaster = $("#id").val();--%>
<%--        var date = $("#date").val();--%>
<%--        var location = $("#location").val();--%>
<%--        var type = $('#type').val();--%>
<%--        var grade = $('#grade').val();--%>
<%--        var note = $('#note').val();--%>
<%--        var reportingUnit = $('#reportingUnit').val();--%>
<%--        var con = JSON.stringify({"ID": idCommDisaster.value, "disasterDate": date.value,--%>
<%--            "location":location.value, "disasterType":type.value, "grade":grade.value, "note":note.value,--%>
<%--            "reportingUnit":reportingUnit.value});--%>
<%--        $.ajax({--%>
<%--            type: "POST",--%>
<%--            dataType: "json",--%>
<%--            contentType: "application/json",--%>
<%--            url: "http://localhost:8080/disaster/generator",--%>
<%--            data: con,--%>
<%--            success: function (data) {--%>
<%--                if (data.code == "S01") {--%>
<%--                    alert(data.message);--%>
<%--                } else {--%>
<%--                    alert(data.message);--%>
<%--                }--%>
<%--            },--%>
<%--        });--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>

