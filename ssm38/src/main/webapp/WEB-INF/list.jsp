<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/5/27
  Time: 9:32
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
    function go(num) {
        document.cha.page.value=+num;
        document.cha.submit();
    }
    function xun() {
        document.cha.page.value='1';
        document.cha.submit();
    }
    function add() {
        location="xl";
    }
</script>
<body>
<table>
<form action="list" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <tr>
        <td>编号</td>
        <td>楼层</td>
        <td>会议事编号</td>
        <td>名称</td>
        <td>容量</td>
        <td>电视</td>
        <td>投影</td>
        <td>开放预订</td>
        <td>是否可用</td>
        <td>
            <input type="button" value="添加" onclick="add()">
        </td>
    </tr>

    <c:forEach items="${pageInfo.list}" var="l">
        <tr>
            <td>${l.id}</td>
            <td>${l.cname}</td>
            <td>${l.hid}</td>
            <td>${l.hname}</td>
            <td>${l.count}</td>
            <td>${l.tv}</td>
            <td>${l.touxing}</td>
            <td>${l.kfyd}</td>
            <td>${l.sfky}</td>
        </tr>
    </c:forEach>
</form>
</table>
当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录
<button onclick="go('1')">首页</button>
<button onclick="go('${pageInfo.prePage}')">上一页</button>
<button onclick="go('${pageInfo.nextPage}')">下一页</button>
<button onclick="go('${pageInfo.pages}')">尾页</button>
</body>
</html>
