<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/3
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
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
            //明细
            function find(status) {
                if(status==3){
                    alert("请先审核");
                }else{
                    location="historyDate";
                }
            }
            //添加
            function toadd() {
                location="toadd";
            }
            //修改
            function toupdate(id) {
                location="selectGoodById?id="+id;
            }
</script>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
    <link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>
<form action="list" method="post" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <table>
    <tr>
        <td>编号</td>
        <td>店铺名称</td>
        <td>店铺等级</td>
        <td>审核时间</td>
        <td>审核状态</td>
        <td>审核明细</td>
        <td>
            <input type="button" value="添加" onclick="toadd()">
        </td>
    </tr>

        <c:forEach items="${pageInfo.list}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.name}</td>
                <td>${u.rank}</td>
                <td>${u.applydate}</td>
                <td>
                        ${u.status==0?"否":u.status==1?"是":"未审核"}
                </td>
                <td>
                    <input type="button" id="${u.id}" value="明细" onclick="find(${u.status})" >
                </td>
                <td>
                    <input type="button" value="修改" onclick="toupdate(${u.id})">
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
