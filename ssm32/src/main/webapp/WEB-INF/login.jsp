<%--
  Created by IntelliJ IDEA.
  User: yangjun
  Date: 2019/4/14
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>

<form method="post" action="login" name="">
<table>
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
                    var uname=$("[name='uname']").val();
                    var pwd=$("[name='pwd']").val();
                    $.post("login",
                        {"uname":uname,"pwd":pwd},
                        function (data) {
                            if(data==null){
                                alert("用户名或密码错误");
                                $("[name='uname']").val('');
                                $("[name='pwd']").val('');
                            }else{
                                alert("登录成功");
                                location="list";
                            }
                        },
                        "json"
                    )
                }
            </script>
</html>
