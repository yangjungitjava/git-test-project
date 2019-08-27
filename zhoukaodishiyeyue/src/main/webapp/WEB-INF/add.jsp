<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/11
  Time: 9:53
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
    function selectTwo(cid) {
        $("#tid").empty();
        $.post("selectTwo",{cid:cid},function (data) {
            for (var i in data){
                var ops="<option value="+data[i].tid+">"+data[i].tname+"</option>"
                $("#tid").append(ops);
            }
        },"json")
    }
    $(function (cid) {
        var cid=$("#cid").val();
        $("#tid").empty();
        $.post("selectTwo",{cid:cid},function (data) {
            for (var i in data){
                var ops="<option value="+data[i].tid+">"+data[i].tname+"</option>"
                $("#tid").append(ops);
            }
        },"json")
    })
</script>
<body>
<table>
<form action="add" method="post">
    <tr>
        <td>查询品牌</td>
        <td>
            <select name="cid">
                <c:forEach items="${list}" var="b">
                    <option id="cid" value="${b.cid}" onclick="selectTwo(${b.cid})">${b.cname}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>查询类别</td>
        <td>
            <select name="tid" id="tid">

            </select>
        </td>
    </tr>
    <tr>
        <td>名称</td>
        <td>
            <input type="hidden" name="id" value="${s.id}">
            <input type="text" name="name" value="${s.name}">
        </td>
    </tr>
    <tr>
        <td>单价</td>
        <td><input type="text" name="price" value="${s.price}"></td>
    </tr>
    <tr>
        <td>数量</td>
        <td><input type="text" name="count" value="${s.count}"></td>
    </tr>

    <tr>
        <td colspan="2">
            <input type="submit" value="提交">
        </td>
    </tr>
</form>
</table>
</body>
</html>
