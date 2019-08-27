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
<span>购买商品后，将商品添加到我的商品列表中${userinfo.uname}</span>
<form method="post" action="" name="">
    <%--<input type="" name="" value="">
    <input type="" value="" onclick="">--%>
    <table>
        <tr>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>发布时间</td>
            <td>商家</td>
            <td>商品类型</td>
        </tr>

        <c:forEach items="${list}" var="g">
            <tr>
                <td>${g.gid}</td>
                <td>${g.gname}</td>
                <td>${g.price}</td>
                <td>${g.gtime}</td>
                <td>${g.shangjia}</td>
                <td>${g.cname}</td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
