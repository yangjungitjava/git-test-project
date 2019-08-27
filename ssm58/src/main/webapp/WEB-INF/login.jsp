<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/21
  Time: 20:13
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
    function unique() {
        $.post("unique",$("form").serialize(),function (data) {
            if(data<1){
                alert("您填写的用户名不存在")
            }
        },"json")
    }
</script>
<body>
<table>
<form>
    ${info}
    <tr>
        <td>用户名</td>
        <td><input type="text" name="username" onchange="unique()"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="text" name="pwd"></td>
    </tr>
    <tr>
        <td colspan="2">
        <input type="submit" value="登录">
        </td>
    </tr>
</form>
</table>
</body>
</html>
