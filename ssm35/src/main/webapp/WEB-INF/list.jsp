<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/5/20
  Time: 9:35
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
            //全不选
            function qbx() {
                $(".ck").each(function () {
                    $(this).attr("checked",false);
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
                    ids=","+this.value;
                });
                ids=ids.substring(1);
                location="plsc?ids="+ids;
            }
            //添加
            function add() {
                location="add";
            }
        </script>
<body>
<form action="list" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <table>
    <tr>
        <td>
            <input type="button" value="全选" onclick="qx()">
            <input type="button" value="全不选" onclick="qbx()">
            <input type="button" value="反选" onclick="fx()">
            <input type="button" value="批量删除" onclick="plsc()">
        </td>
        <td>序号</td>
        <td>名称</td>
        <td>单价</td>
        <td>库存量</td>
        <td>所属品牌</td>
        <td>所属类型</td>
        <td><input type="button" value="添加" onclick="add()"></td>
    </tr>

        <c:forEach items="${pageInfo.list}" var="g">
            <tr>
                <td>
                    <input type="checkbox" class="ck" value="${g.gid}">
                </td>
                <td>${g.gid}</td>
                <td>${g.gname}</td>
                <td>${g.price}</td>
                <td>${g.count}</td>
                <td>${g.pname}</td>
                <td>${g.cname}</td>
                <td>
                    <input type="button" value="修改" onclick="update('${g.gid}')">
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
        当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录
        <button onclick="go('1')">首页</button>
        <button onclick="go('${pageInfo.prePage}')">上一页</button>
        <button onclick="go('${pageInfo.nextPage}')">下一页</button>
        <button onclick="go('${pageInfo.pages}')">尾页</button>
</body>
</html>
