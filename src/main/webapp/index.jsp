<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title>灾情信息登记表</title>
    <script src="js/jquery-1.8.3.js"></script>
</head>

<body>
<!-- 设置背景图片 -->
<div style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">
<img src="img/background.png" height="100%" width="100%" style="left:0; top:0;">
</div> 

<!-- 输入栏 -->
<center style = "top:100px">
<!-- 标题-->
<h1 ><font color=#E9F0FB>灾情信息登记表</font></h1>
<br />
<br/>
<!-- 按钮 -->
<input type="button" name="201" value = "201  人员死亡记录    " onclick="window.location.href='201.jsp'"  style="width:250px; height:50px; background-color:#E9F0FB; ">
    &emsp;
<input type="button" name="202" value = "202  通信系统灾情    " onclick="window.location.href='202.jsp'" style="width:250px; height:50px; background-color:#E9F0FB; ">
<br />
<br />
<input type="button" name="203" value = "203  房屋土木灾情" onclick="window.location.href='203.jsp'"  style="width:250px; height:50px; background-color:#E9F0FB;">
    &emsp;
<input type="button" name="204" value = "204  人员失踪记录" onclick="window.location.href='204.jsp'"  style="width:250px; height:50px; background-color:#E9F0FB;">
<br />
<br />
<input type="button" name="301" value = "301  房屋砖混灾情" onclick="window.location.href='301.jsp'"  style="width:250px; height:50px; background-color:#E9F0FB;">
    &emsp;
<input type="button" name="302" value = "302  交通事故灾情    " onclick="window.location.href='302.jsp'" style="width:250px; height:50px; background-color:#E9F0FB; ">
<br />
<br />
<input type="button" name="401" value = "401  滑坡记录表      " onclick="window.location.href='401.jsp'" style="width:250px; height:50px; background-color:#E9F0FB;">
    &emsp;
<input type="button" name="402" value = "402  崩塌记录表      " onclick="window.location.href='402.jsp'" style="width:250px; height:50px; background-color:#E9F0FB;">
<br /> 
<br />
<input type="button" name="501" value = "501  地震预测表      " onclick="window.location.href='501.jsp'" style="width:250px; height:50px; background-color:#E9F0FB;">
    &emsp;
<input type="button" name="502" value = "502  基本震情表      " onclick="window.location.href='502.jsp'" style="width:250px; height:50px; background-color:#E9F0FB;">
<br />
<br />


<input type="button" name="jump" value="查看数据" onclick="window.location.href='http://114.116.87.15:8080/mshd/coll'" style="width:250px; height:50px; background-color:#E9F0FB;">
</center>
</body>
</html>