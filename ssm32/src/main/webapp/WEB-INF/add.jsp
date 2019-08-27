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

<form method="post" action="insertOrder" name="">
    <table>
        <tr>
            <td>公司类型</td>
            <td>
                <select name="ooid">
                    <c:forEach items="${list}" var="l">
                        <option value="${l.ooid}">${l.oname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>名称</td>
            <td>
                <input type="text" name="cname">
            </td>
        </tr>

        <tr>
            <td>备注</td>
            <td>
                <input type="text" name="beizhu">
            </td>
        </tr>

        <tr>
            <td>期限</td>
            <td>
                <input type="text" name="qixian">
            </td>
        </tr>

        <tr>
            <td>签订时间</td>
            <td><input type="" name="qtime"></td>
        </tr>

        <tr>
            <td>预计完成时间</td>
            <td><input type="date" name="ytime"></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="添加">
            </td>
        </tr>


    </table>
</form>
</body>
</html>
