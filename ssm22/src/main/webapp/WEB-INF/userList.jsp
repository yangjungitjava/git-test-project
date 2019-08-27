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
<form method="post" action="userList">
    <table>

        <tr>
            <td>菜单</td>
            <td>
                <input type="hidden" name="userid" value="${userinfo.userid}"><%--value="${userinfo.userid}"从session里面拿出用户的id--%>
                <select name="gid"><%--name="gid"而不是name="gname"  "insert into user_goods (userid,gid,address,ugtime,state) values (#{userid},#{gid},#{address},now(),0)--%>

                    <c:forEach items="${list}" var="g">
                        <option value="${g.gid}">${g.gname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>送餐地点</td>
            <td>
                <input type="text" name="address">
            </td>
        </tr>


        <tr>
            <td colspan="10">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
