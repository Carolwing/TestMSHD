<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/jquery-1.8.3.js"></script>
</head>
<script src="${pageContext.request.contextPath}/js/My97DatePicker/WdatePicker.js"></script>
<script src="${pageContext.request.contextPath}/js/province.js"></script>
<body>
<div style="position:absolute; width:100%; height:100%; z-index:-1; left:0; top:0;">
    <img src="img/background.png" height="100%" width="100%" style="left:0; top:0;">
</div>
<center>
    <h1><font color=#E9F0FB>上报</font></h1>
    <form id="saveForm" action="${pageContext.request.contextPath}/collapserecord/generator" enctype="multipart/form-data" method="post" modelAttribute="CollapseRecord">
        <table align="center" bgcolor="#E9F0FB" border="1" cellpadding="0">
            <tbody>
<%--            <tr>--%>
<%--                <td>编码</td><td><input  type="text" value="${CollapseRecord.disasterID}" name="disasterID"/></td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>上报时间</td><td><input type="text" value="${CollapseRecord.disasterDate}" name="disasterDate"/></td>--%>
<%--            </tr>--%>
            <tr>
                <td>上报时间</td>
                <td><input type="text" name="disasterDate" class="Wdate" onClick="WdatePicker({dateFmt:'yyyyMMddHHmm'})" readonly="readonly" value="${CollapseRecord.disasterDate}"/></td>
            </tr>
            <tr>
                <td>地点</td>
                <td>
<%--                    <input type="text" value="${CollapseRecord.location}" name="location"/>--%>
                    <input type="text" value="${CollapseRecord.location}" name="location" readonly="readonly" id="addr-show">

                    <!-- 省份选择 -->
                    <select id="prov" name="prov" onchange="showCity(this)">
                        <option>=请选择省份=</option>
                    </select>
                    <!-- 城市选择 -->
                    <select id="city" onchange="showCountry(this)">
                        <option>=请选择城市=</option>
                    </select>
                    <!-- 区县选择 -->
                    <select id="country" onchange="selectCountry(this)">
                        <option>=请选择县区=</option>
                    </select>

                    <button type="button" class="btn" onClick="showAddr()">确定</button>

                    <script type="text/javascript">
                        $(function () {
                            var current_prov;
                            var current_city;
                            var current_country;
                            /* 自动加载省份列表 */
                            showPro();
                        });
                        function showPro(){
                            $(".btn").disabled = true;
                            var len = province.length;
                            for(var i = 0; i < len; i++) {
                                var provOpt = document.createElement("option");
                                provOpt.innerText = province[i]['name'];
                                provOpt.value = i;
                                prov.appendChild(provOpt);
                            }
                        };
                        /*根据所选的省份来显示城市列表*/
                        function showCity(obj) {
                            var val = obj.options[obj.selectedIndex].value;
                            current_prov = val;
                            if (val >=0) {
                                city.style.display = 'inline-block';
                                country.style.display = 'none';
                            } else {
                                city.style.display = 'none';
                                country.style.display = 'none';
                            }
                            if (val != null) {
                                city.length = 1;
                                if (province[val]) {
                                    var cityLen = province[val]["city"].length;
                                }
                                for (var j = 0; j < cityLen; j++) {
                                    var cityOpt = document.createElement('option');
                                    cityOpt.innerText = province[val]["city"][j].name;
                                    cityOpt.value = j;
                                    city.appendChild(cityOpt);
                                }
                            }
                        };
                        /*根据所选的城市来显示县区列表*/
                        function showCountry(obj) {
                            var val = obj.options[obj.selectedIndex].value;
                            if (val >=0) {
                                country.style.display = 'inline-block';
                            } else {
                                country.style.display = 'none';
                            }
                            current_city = val;
                            if (val != null) {
                                country.length = 1;
                                if (province[current_prov]["city"][val]) {
                                    var countryLen = province[current_prov]["city"][val].districtAndCounty.length;
                                }
                                if(countryLen == 0){
                                    addrShow.value = province[current_prov].name + '-' + province[current_prov]["city"][val].name;
                                    return;
                                }
                                for (var n = 0; n < countryLen; n++) {
                                    var countryOpt = document.createElement('option');
                                    countryOpt.innerText = province[current_prov]["city"][val].districtAndCounty[n];
                                    countryOpt.value = n;
                                    country.appendChild(countryOpt);
                                }
                            }
                        };

                        function selectCountry(obj) {
                            current_country = obj.options[obj.selectedIndex].value;
                            $(".btn").disabled = false;

                        };
                        function showAddr() {
                            var ss = province[current_prov].name + "-" +
                                province[current_prov]['city'][current_city].name + "-" +
                                province[current_prov]['city'][current_city]['districtAndCounty'][current_country];
                            $("#addr-show").val(ss);
                        }
                    </script>
                </td>
            </tr>
            <tr>
                <td>类型</td>
                <td>
                    <select id="disasterType" name="disasterType">
                        <option value="小型">小型</option>
                        <option value="中型">中型</option>
                        <option value="大型">大型</option>
                        <option value="特大型">特大型</option>
                    </select>
                    <script>
                        form.disasterType.value = '${CollapseRecord.disasterType}';
                    </script>
                </td>
            </tr>
<%--            <tr>--%>
<%--                <td>灾害程度</td><td><input type="text" value="${CollapseRecord.status}" name="status"/></td>--%>
<%--            </tr>--%>
            <tr>
                <td>灾害程度</td>
                <td>
                    <select id="status" name="status">
                        <option value="特大">特大</option>
                        <option value="重大">重大</option>
                        <option value="较大">较大</option>
                        <option value="一般">一般</option>
                    </select>
                    <script>
                        form.status.value = '${CollapseRecord.status}';
                    </script>
                </td>
            </tr>

            <tr>
                <td>灾情描述</td><td><input type="text" value="${CollapseRecord.note}" name="note"/></td>
            </tr>
            <tr>
                <td>上报单位</td><td><input type="text" value="${CollapseRecord.reportingUnit}" name="reportingUnit"/></td>
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


