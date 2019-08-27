<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/5/20
  Time: 9:10
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
<form action="login">
    <table>
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
            <input type="button" value="登录" onclick="login()">
        </td>
    </tr>
    </table>
</form>
</body>
                <script>
                    function login(){
                        //获取用户名
                        var username=$("[name='username']").val();
                        //获取密码
                        var pwd=$("[name='pwd']").val();
                        $.post("login",
                            {"username":username,"pwd":pwd},
                            function (data) {
                                if(data==null){
                                    alert("用户名或密码不正确");
                                    $("[name='username']").val('');
                                    $("[name='pwd']").val('');
                                }else{
                                    location="list";
                                }
                            },
                            "json"
                        )
                    }
                </script>
</html>
