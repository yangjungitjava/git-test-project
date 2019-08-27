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
<span>${userinfo.name}个人订单表</span>
<form method="post" action="goodList">

    <table>
        <tr>
            <td>菜品名称</td>
            <td>送餐地点</td>
            <td>订餐时间</td>
            <td>订单状态</td>
        </tr>

        <c:forEach items="${list}" var="l">
            <tr>
                <td>${l.gname}</td>
                <td>${l.address}</td>
                <td>${l.ugtime}</td>
                <td>${l.state==0?"等待配送":"已完成"}</td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
