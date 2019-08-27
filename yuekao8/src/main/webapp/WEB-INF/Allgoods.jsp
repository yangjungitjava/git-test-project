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
<script>
    //修改
    function updategood(gid) {
        window.location.href="update?gid="+gid;
    }
</script>
<body>
<span>用户：列表展示全部商品</span>
<form method="post" action="Allgoods" name="">
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
            <td>
                <a href="MyGood?uid=${userinfo.uid}">查看我购买的商品</a><%--从session中拿到用户的id--%>
            </td>
        </tr>

        <c:forEach items="${list}" var="g">
            <tr>
                <td>${g.gid}</td>
                <td>${g.gname}</td>
                <td>${g.price}</td>
                <td>${g.gtime}</td>
                <td>${g.shangjia}</td>
                <td>${g.cname}</td>
                <td>
                    <a href="addGood?uid=${userinfo.uid}">购买</a>
                </td>
                <td>
                    <button onclick="updategood(${g.gid})">修改</button>
                </td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
