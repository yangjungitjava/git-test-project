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
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/css.css" type="text/css"></link>
</head>
<body>
<script>
    function add() {
        location = "add";
    }

    function toupdate(id) {
        location = "editor?id=" + id;
    }

</script>
<form method="post">
    <input type="text" name="name" value="${name}">
    <input type="submit" value="搜索">
    <table>
        <tr>
            <td>产品编号</td>
            <td>产品名称</td>
            <td>一级类别</td>
            <td>二级类别</td>
            <td>数量</td>
            <td><input type="button" value="添加" onclick="add()"></td>
        </tr>

        <c:forEach items="${list}" var="c">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.oname}</td>
                <td>${c.tname}</td>
                <td>${c.num}</td>
                <td>
                    <input type="button" value="修改" onclick="toupdate('${c.id}')">
                </td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
