<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/24
  Time: 9:53
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
<body>
<table>
    <script>
        function go(num) {
            document.cha.page.value=num;
            document.cha.submit();
        }
        function xun() {
            document.cha.page.value='1';
            document.cha.submit();
        }
        function plsc() {
            var ids="";
            var cks=$(".ck:checked");
            cks.each(function () {
                ids=","+this.value;
            })
            ids=ids.substring(1);
            location="plsc?ids="+ids;
        }
        function add() {
            location="toadd";
        }
        function update(id) {
            location="selectById?id="+id;
        }
        function kaiqi() {
            location="kaiqi";
        }
        function pinbi() {
            location="pinbi";
        }
    </script>
<form action="list" method="post" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <tr>
        <td>
            <input type="button" value="批量删除" onclick="plsc()">
        <input type="button" value="开启" onclick="kaiqi()">
        <input type="button" value="屏蔽" onclick="pinbi()">
        </td>
        <td>分类id</td>
        <td>分类名称</td>
        <td>分类状态</td>
        <td><input type="button" value="添加" onclick="add()"></td>
    </tr>

    <c:forEach items="${pageInfo.list}" var="l">
        <tr>
            <td>
                <input type="checkbox" class="ck" value="${l.id}">
            </td>
            <td>${l.id}</td>
            <td>${l.name}</td>
            <td>${l.stack==1?"有效":"无效"}</td>
            <td>
                <input type="button" value="修改" onclick="update(${l.id})">
            </td>
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
