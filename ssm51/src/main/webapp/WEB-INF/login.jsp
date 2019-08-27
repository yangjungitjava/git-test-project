<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/15
  Time: 10:50
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
                location="selectType"
            }
</script>
<body>
<table>
<form>
    <center>${info}</center>
    <tr>
        <td>用户名</td>
        <td><input type="text" name="username"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="text" name="pwd"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="登录">
            <input type="button" value="注册" onclick="add()">
        </td>
    </tr>
</form>
</table>
</body>
</html>
