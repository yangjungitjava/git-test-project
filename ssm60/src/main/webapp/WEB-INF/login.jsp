<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/24
  Time: 9:23
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
<form>
    <tr>
        <td>用户名</td>
        <td><input type="text" name="uname"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="text" name="pwd"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" value="登录" onclick="login()">
        </td>
    </tr>
</form>
</table>
</body>
<script>
    function login() {
        $.post("login",$("form").serialize(),function (data) {
            if(data==null){
                alert("用户名或密码错误");
            }else{
                alert("11");
                location= "list";
            }
        },"json")
    }
</script>
</html>
