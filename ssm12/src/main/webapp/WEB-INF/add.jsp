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
<title>添加</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>

<form method="post" action="toadd">
    <table>
        <tr>
            <td>产品编号</td>
            <td><input type="text" name="cid"></td>
        </tr>


        <tr>
            <td>产品名称</td>
            <td><input type="text" name="cname"></td>
        </tr>


        <tr>
            <td>一级类别</td>
            <td><input type="text" name="first"></td>
        </tr>


        <tr>
            <td>二级类别</td>
            <td><input type="text" name="two"></td>
        </tr>


        <tr>
            <td>数量</td>
            <td><input type="text" name="count"></td>
        </tr>


        <tr>
            <td colspan="10">
                <input type="submit" value="添加">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
