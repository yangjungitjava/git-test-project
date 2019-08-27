<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/3
  Time: 15:14
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

               //反选
               function fx() {
                   $(".ck").each(function () {
                       $(this).attr("checked", !$(this).attr("checked"));
                   })
               }

           </script>
<body>
<form action="historyDate" method="post">
    <table>
    <tr>
        <td>
            <input type="button" value="反选" onclick="fx()">
        </td>
        <td>店铺名称</td>
        <td>审核状态</td>
        <td>驳回理由</td>
        <td>审核时间</td>
    </tr>

        <c:forEach items="${list}" var="l">
            <tr>
                <td>
                    <input type="checkbox" class="ck" value="${userinfo.uid}">
                </td>
                <td>${l.name}</td>
                <td>${l.status}</td>
                <td>${l.reject}</td>
                <td>${l.applydate}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
