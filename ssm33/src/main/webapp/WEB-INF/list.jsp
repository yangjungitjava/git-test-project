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
<script>
    //分页
    function go(num) {
        document.cha.page.value=+num;
        document.cha.submit();
    }
    function xun() {
        document.cha.page.value='1';
        document.cha.submit();
    }
    //全选
    function qx() {
        $(".ck").each(function () {
            $(this).attr("checked",true);
        })
    }
    //反选
    function fx() {
        $(".ck").each(function () {
            $(this).attr("checked",!$(this).attr("checked"));
        })
    }
    //批量删除
    function plsc() {
        var ids="";
        var cks=$(".ck:checked");
         cks.each(function () {
           ids+=","+this.value;
       });
        ids=ids.substring(1);
        $.post("plsc", {ids:ids}, function (data) {
                alert(ids);
                location="list";
            },
            "json"
        );
    }
    //添加
    function add() {
        location="add";
    }

</script>
<form method="post" action="list" name="cha">
    <input type="text" name="name" value="${name}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <table>
        <tr>
            <td>
                <input type="button" value="全选" onclick="qx()">
                <input type="button" value="反选" onclick="fx()">
                <input type="button" value="批量删除" onclick="plsc()">
            </td>
            <td>编号</td>
            <td>名称</td>
            <td>简介</td>
            <td>单价</td>
            <td>起始时间</td>
            <td>更新时间</td>
            <td>类型</td>
            <td>头像</td>
            <td>
                <input type="button" value="添加" onclick="add()">
            </td>
        </tr>

        <c:forEach items="${pageInfo.list}" var="o">
            <tr>
                <td>
                    <input type="checkbox" class="ck" value="${o.id}">
                </td>
                <td>${o.id}</td>
                <td>${o.name}</td>
                <td>${o.content}</td>
                <td>${o.price}</td>
                <td>${o.qtime}</td>
                <td>${o.gtime}</td>
                <td>${o.cname}</td>
                <td><img src="${o.img}"></td>
            </tr>
        </c:forEach>
    </table>
</form>
            当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录
            <button onclick="go('1')">首页</button>
            <button onclick="go('${pageInfo.prePage}')">上一页</button>
            <button onclick="go('${pageInfo.nextPage}')">下一个</button>
            <button onclick="go('${pageInfo.pages}')">尾页</button>
</body>
</html>
