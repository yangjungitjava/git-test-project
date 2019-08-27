<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/11
  Time: 9:10
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
    //分页
    function page(num) {
        document.cha.page.value=num;
        document.cha.submit();
    }
    function xun() {
        document.cha.page.value='1';
        document.cha.submit();
    }
    function qx() {
        $(".ck").each(function () {
            $(this).attr("checked",true);
        })
    }
    function qbx() {
        $(".ck").each(function () {
            $(this).attr("checked",false);
        })
    }
    function fx() {
        $(".ck").each(function () {
            $(this).attr("checked",!$(this).attr("checked"));
        })
    }
    //批量删除
    function plsc() {
        //定义一个空字符串
        var ids="";
        //获取所有选中的复选框
        var cks=$(".ck:checked");
        cks.each(function () {
            ids+=","+this.value;
        });
        ids=ids.substring(1);
        location="plsc?ids="+ids;
    }
    function add() {
        location="selectOne";
    }
    function update(id) {
        location="selectbyid?id="+id;
    }
</script>
<body>
<table>
<form action="list" method="post" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    价格区间:<input type="text" name="begin" value="${begin}">
    <input type="text" name="end" value="${end}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <tr>
        <td>
            <input type="button" value="全选" onclick="qx()">
            <input type="button" value="全不选" onclick="qbx()">
            <input type="button" value="反选" onclick="fx()">
            <input type="button" value="批量删除" onclick="plsc()">
        </td>
        <td>编号</td>
        <td>名称</td>
        <td>单价</td>
        <td>库存量</td>
        <td>所属品牌</td>
        <td>所属类型</td>
        <td>
            <input type="button" value="添加" onclick="add()">
        </td>
    </tr>

    <c:forEach items="${pageInfo.list}" var="g">
        <tr>
            <td>
                <input type="checkbox" class="ck" value="${g.id}">
            </td>
            <td>${g.id}</td>
            <td>${g.name}</td>
            <td>${g.price}</td>
            <td>${g.count}</td>
            <td>${g.cname}</td>
            <td>${g.tname}</td>
            <td>
                <input type="button" value="修改" onclick="update('${g.id}')">
            </td>
        </tr>
    </c:forEach>
</form>
</table>
当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录.
<button onclick="page('1')">首页</button>
<button onclick="page('${pageInfo.prePage}')">上一页</button>
<button onclick="page('${pageInfo.nextPage}')">下一页</button>
<button onclick="page('${pageInfo.pages}')">尾页</button>
</body>
</html>
