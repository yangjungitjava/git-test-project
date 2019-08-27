<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/21
  Time: 21:06
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
    function add() {
        location="selectType";
    }
    //反选
    function fx() {
        $(".ck").each(function () {
            $(this).attr("checked",!$(this).attr("checked"))
        })
    }
    //判断是否勾选商品
    function tj(id) {
        if($(".ck").is(':checked')) {
                location="order?id="+id;
            }else{
            alert("请选择要购买的商品");
        }
    }
</script>
<body>
<table>
<form>
    <tr>
        <td>
            <input type="button" value="反选" onclick="fx()">
        </td>
        <td>商品id</td>
        <td>商品名称</td>
        <td>商品单价</td>
        <td>商品描述</td>
    </tr>

    <c:forEach items="${list}" var="p">
        <tr>
        <td>
            <input type="checkbox" class="ck" >
        </td>
        <td>${p.id}</td>
        <td>${p.pname}</td>
        <td>${p.price}</td>
        <td>${p.descs}</td>
        <td>
            <input type="button" value="添加" onclick="add()">
        </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6">
            <input type="button" value="提交订单" onclick="tj('${p.id}')">
        </td>
    </tr>
</form>
</table>
</body>
</html>
