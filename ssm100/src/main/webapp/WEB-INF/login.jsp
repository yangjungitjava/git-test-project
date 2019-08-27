<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/7/2
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
    <link rel="stylesheet" href="css/css.css" type="text/css"></link>
<%-- &lt;%&ndash;  使用md5加密的方法：下载md5.js文件，在网页中引用该文件:&ndash;%&gt;
    <script type="text/javascript" src="jquery/md5.js"></script>
   &lt;%&ndash; 在你需要使用MD5加密的地方如此调用:&ndash;%&gt;
    <script type="text/javascript">hash = hex_md5("input string"); </script>--%>
</head>
<body>
<table>
<form action="addUser" method="post">
    <tr>
        <td>用户名</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type="text" name="pwd"></td>
    </tr>
    <tr>
        <td colspan="2">
          <input type="submit" value="注册" onclick="login()">
        </td>
    </tr>
</form>
</table>
</body>
<script>
    function login() {
        alert("注册成功")
    }
</script>
</html>
