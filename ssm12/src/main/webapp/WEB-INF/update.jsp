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
<title>修改</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>

<form method="post" action="toupdate">
    <table>
        <tr>
            <td>产品编号</td>

            <td>
                <input type="hidden" name="id" value="${g.id}">
                <input type="text" name="cid" value="${g.cid}">
            </td>
        </tr>

        <tr>
            <td>产品名称</td>
            <td><input type="text" name="cname" value="${g.cname}"></td>
        </tr>


        <tr>
            <td>一级类别</td>
            <td><input type="text" name="first" value="${g.first}"></td>
        </tr>


        <tr>
            <td>二级类别</td>
            <td><input type="text" name="two" value="${g.two}"></td>
        </tr>


        <tr>
            <td>数量</td>
            <td><input type="text" name="count" value="${g.count}"></td>
        </tr>


        <tr>
            <td colspan="10">
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
