<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/5/27
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
    <link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<script>
            $.post("selectxl",null,function (data) {
                for(var i in data){
                    var ops="<option value="+data[i].cid+">"+data[i].cname+"</option>";
                    $("#cid").append(ops);
                }
            },"json")
</script>
<body>
<table>
<form action="inserthuiyi">
    <tr>
        <td>楼层</td>
        <td >
            <select name="cid" id="cid">

            </select>
        </td>
    </tr>

    <tr>
        <td>会议室编号</td>
        <td><input type="text" name="hid"></td>
    </tr>
    <tr>
        <td>容量</td>
        <td><input type="text" name="count"></td>
    </tr>
    <tr>
        <td>有电视机</td>
        <td>
            <input type="radio" name="tv" value="是">是
            <input type="radio" name="tv" value="否">否
        </td>
    </tr>
    <tr>
        <td>有投影仪</td>
        <td>
        <input type="radio" name="touxing" value="是">是
        <input type="radio" name="touxing" value="否">否
        </td>
    </tr>
    <tr>
        <td>允许开放预订</td>
        <td>
        <input type="radio" name="kfyd" value="是">是
        <input type="radio" name="kfyd" value="否">否
        </td>
    </tr>
    <tr>
        <td>启用</td>
        <td>
        <input type="radio" name="sfky" value="是">是
        <input type="radio" name="sfky" value="否">否
        </td>
    </tr>

    <tr>
        <td colspan="2">
        <input type="submit" value="添加">
        </td>
    </tr>
</form>
</table>
</body>
</html>
