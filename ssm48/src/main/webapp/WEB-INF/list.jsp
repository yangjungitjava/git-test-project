<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/9
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
    <link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<script>
    function update(id) {
        location="selectById?id="+id;
    }
</script>
<body>
<form>
    <input type="text" name="mohu" value="${mohu}">
    <input type="submit" value="搜索">
    <table>
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>学院</td>
        <td>日期</td>
        <td>宿舍</td>
    </tr>

        <c:forEach items="${list}" var="s">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.sex}</td>
                <td>${s.suo}</td>
                <td>${s.date}</td>
                <td>${s.dang}</td>
                <td>
                    <<input type="button" value="更换宿舍" onclick="update(${s.id})">
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
