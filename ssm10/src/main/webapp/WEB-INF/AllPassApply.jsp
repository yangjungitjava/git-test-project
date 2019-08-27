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
<title>欢迎${userinfo.uname}同学进入审核通过列表</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>

<form method="post">

    <table>
        <tr>
            <td>学生姓名</td>
            <td>课程名称</td>
            <td>审核状态</td>
        </tr>

        <c:forEach items="${list}" var="a">
            <tr>
                <td>${a.uname}</td>
                <td>${a.cname}</td>
                <td>${a.state}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
