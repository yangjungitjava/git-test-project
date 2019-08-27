<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/1
  Time: 10:45
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
            function add2(cid) {
                $("#tid").empty();
                $.post("add2",{"cid":cid},function (data) {
                    for (var i in data){
                        var ops="<option value="+data[i].tid+">"+data[i].tname+"</option>"
                        $("#tid").append(ops);
                    }
                },"json")
            }

            $(function () {
                $("#tid").empty();
                var cid=$("#cid").val();
                $.post("add2",{"cid":cid},function (data) {
                    for (var i in data){
                        var ops="<option value="+data[i].tid+">"+data[i].tname+"</option>";
                        $("#tid").append(ops);
                    }
                },"json")
            })


        </script>
<body>
<table>
<form enctype="multipart/form-data" action="insert" method="post">
    <tr>
        <td>添加1</td>
        <td>
            <select name="cid">
                <c:forEach items="${list}" var="l">
                <option value="${l.cid}" id="cid" onclick="add2(${l.cid})">${l.cname}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>添加2</td>
        <td>
            <select id="tid" name="tid">
            </select>
        </td>
    </tr>
    <tr>
        <td>头像</td>
        <td>
            <input type="file" name="multipartFile">
        </td>
    </tr>
    <tr>
        <td>日期</td>
        <td>
            <input type="date" name="time">
        </td>
    </tr>
    <tr>
        <td>名称</td>
        <td>
            <input type="text" name="gname">
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
