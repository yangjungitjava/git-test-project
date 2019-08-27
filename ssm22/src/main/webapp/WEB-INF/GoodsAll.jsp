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
<title>列表</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>
<span>所有订单信息表${userinfo.name}</span>
<form method="post" action="goodList">

    <table>
        <tr>
            <td>用户姓名</td>
            <td>菜品名称</td>
            <td>送餐地点</td>
            <td>订餐时间</td>
            <td>订单状态</td>
        </tr>

        <c:forEach items="${list}" var="l">
            <tr>
                <td>${l.name}</td>
                <td>${l.gname}</td>
                <td>${l.address}</td>
                <td>${l.ugtime}</td>
                <td>
                    <c:if test="${l.state==0}">
                        <a href="updateGoods?userid=${userid}&gid=${gid}">进行配送</a>
                    </c:if>
                    <c:if test="${l.state==1}">
                        完成配送
                    </c:if>


                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
