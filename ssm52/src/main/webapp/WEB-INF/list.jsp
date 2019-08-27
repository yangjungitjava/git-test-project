<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/17
  Time: 9:04
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
        document.cha.page.value=num;
        document.cha.submit();
    }
    function xun() {
        document.cha.page.value='1';
        document.cha.submit();
    }
    function fx() {
        $(".ck").each(function () {
            $(this).attr("checked",!$(this).attr("checked"));
        })
    }
    function update(id) {
        location="selectById?id="+id;
    }
    function youhuo() {
        if(kuncun>0){
            location="youhuo";
        }
    }
</script>


<body>
<input type="checkbox" onclick="youhuo">海信
<input type="checkbox" onclick="youhuo">海尔
<input type="checkbox" onclick="youhuo">小米
<input type="checkbox" onclick="youhuo">三星<p/>
<input type="checkbox" onclick="youhuo">仅显示有货
<table>
<form action="list" method="post" name="cha">
    按商品名称查询:<input type="text" name="mohu" value="${mohu}">
    按编号查询:<input type="text" name="gid" value="${gid}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <tr>
        <td>
            <input type="button" onclick="fx()" >
        </td>
        <td>编号</td>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>品牌（中文）</td>
        <td>品牌</td>
        <td>尺寸</td>
        <td>价格</td>
        <td>销量</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="g">
        <tr>
            <td>
                <input type="checkbox" class="ck" value="${g.id}">
            </td>
            <td>${g.id}</td>
            <td>${g.gid}</td>
            <td>${g.gname}</td>
            <td>${g.cbrand}</td>
            <td>${g.brand}</td>
            <td>${g.size}</td>
            <td>${g.price}</td>
            <td>${g.count}</td>
            <td>
                <input type="button" value="价格调整" onclick="update('${g.id}')">
            </td>
        </tr>
    </c:forEach>
</form>
</table>
当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条数据
    <button onclick="go('1')">首页</button>
    <button onclick="go('${pageInfo.prePage}')">上一页</button>
    <button onclick="go('${pageInfo.nextPage}')">下一页</button>
    <button onclick="go('${pageInfo.pages}')">尾页</button>
</body>
</html>
