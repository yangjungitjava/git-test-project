<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/21
  Time: 21:41
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
<body>
<table>
<form action="toadd" method="post">
    <tr>
        <td>商品描述</td>
        <td>
            <select name="describess">
                <c:forEach items="${list}" var="l">
                    <option value="${l.pid}">${l.descs}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td>商品名称</td>
        <td>
            <input type="text" name="pname">
        </td>
    </tr>
    <tr>
        <td>商品单价</td>
        <td>
            <input type="text" name="price">
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
