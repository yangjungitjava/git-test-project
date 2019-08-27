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
<title>管理员选课列表</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>

<form method="post" action="" name="">
    <%--<input type="" name="" value="">
    <input type="" value="" onclick="">--%>
    <table>
        <tr>
            <td>学生姓名</td>
            <td>课程名称</td>
            <td>审核状态</td>
        </tr>

        <c:forEach items="${list}" var="s">
            <tr>
                <td>${s.uname}</td>
                <td>${s.cname}</td>
                <td>${s.state==0?"审核未通过":s.state==1?"审核通过":"未审核"}</td>
            </tr>

        </c:forEach>
    </table>
</form>
</body>
</html>
