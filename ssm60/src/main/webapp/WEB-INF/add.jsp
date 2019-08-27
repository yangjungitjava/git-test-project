<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/24
  Time: 10:32
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
<form action="insert" method="post">

    <tr>
        <td>分类名称</td>
        <td>
            <input type="hidden" name="id" value="${l.id}">
            <input type="text" name="name" value="${l.name}">
        </td>
    </tr>
    <tr>
        <td>是否有效</td>
        <td><input type="text" name="stack" value="${l.stack}"></td>
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
