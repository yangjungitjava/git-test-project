<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/5/20
  Time: 10:20
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
<form action="toadd">
    <table >
    <tr>
        <td>名称</td>
        <td><input type="text" name="gname"></td>
    </tr>
    <tr>
        <td>单价</td>
        <td><input type="text" name="price"></td>
    </tr>
    <tr>
        <td>数量</td>
        <td><input type="text" name="count"></td>
    </tr>
        <tr>
        <td colspan="2">
            <input type="submit" value="添加">
        </td>
    </tr>
    </table>

</form>
</body>
</html>
