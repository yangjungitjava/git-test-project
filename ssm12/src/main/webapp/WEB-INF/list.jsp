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

<form method="post">
    <input type="text" name="mohu" value="${mohu}">
    <input type="submit">
    <table>
        <tr>
            <td>编号</td>
            <td>产品编号</td>
            <td>产品名称</td>
            <td>一级类别</td>
            <td>二级类别</td>
            <td>数量</td>
            <td>
                <input type="button" value="添加" onclick="add()">
            </td>
        </tr>

        <c:forEach items="${list}" var="g">
            <tr>
                <td>${g.id}</td>
                <td>${g.cid}</td>
                <td>${g.cname}</td>
                <td>${g.first}</td>
                <td>${g.two}</td>
                <td>${g.count}</td>
                <td>
                    <input type="button" value="删除" onclick="del('${g.id}')">
                    <input type="button" value="修改" onclick="update('${g.id}')">
                </td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
<script>
    //添加
    function add() {
        location = "add";
    }

    //删除
    function del(id) {
        location = "del?id=" + id;
    }

    //修改
    function update(id) {
        location = "update?id=" + id;
    }
</script>
</html>
