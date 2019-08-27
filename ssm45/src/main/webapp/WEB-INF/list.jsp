<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/5/31
  Time: 20:59
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
            <script>
                //分页
                function go(num) {
                    document.cha.page.value=+num;
                    document.cha.submit();
                }
                //模糊
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
                    //定义一个空字符
                    var ids="";
                    //获取所有选中的复选框
                    var cks=$(".ck:checked");
                    cks.each(function () {
                        ids=","+this.value;
                    });
                    ids=ids.substring(1);
                    location="plsc?ids="+ids;
                }

                /**
                 * 去添加页面
                 */
                function toaddpage() {
                    location="toaddpage";
                }
            </script>
<table>
<form action="list" method="post" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <tr>
        <td>
            <input type="button" onclick="qx()" value="全选">
            <input type="button" onclick="qbx()" value="全不选">
            <input type="button" onclick="fx()" value="反选">
            <input type="button" onclick="plsc()" value="批量删除">
        </td>
        <td>编号</td>
        <td>商品类型</td>
        <td>商品</td>
        <td>日期</td>
        <td>头像</td>
        <td>
            <input type="button" value="添加" onclick="toaddpage()">
        </td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="p">
        <tr>
            <td>
                <input type="checkbox" class="ck" value="${p.gid}">
            </td>
            <td>${p.gid}</td>
            <td>${p.cname}</td>
            <td>${p.tname}</td>
            <td>${p.time}</td>
            <td>
                <img src="${p.img}">
            </td>
        </tr>
    </c:forEach>
</form>
</table>
            当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录
                <button  onclick="go('1')">首页</button>
                <button  onclick="go('${pageInfo.prePage}')">上一页</button>
                <button  onclick="go('${pageInfo.nextPage}')">下一页</button>
                <button  onclick="go('${pageInfo.pages}')">尾页</button>
</body>
</html>
