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

<form method="post" action="addmoive" name="">

    <table>
        <tr>
            <td>电影</td>
            <td>
                <input type="text" name="name" >
            </td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author" ></td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea cols="90" rows="30" name="discrete">
                </textarea>
            </td>
        </tr>
        <tr>
            <td>类型</td>
            <td>
                <c:forEach items="${list}" var="t">
                <input type="checkbox" value="${t.tid}" name="arr">${t.tname}<%--arr表示的是所有的tid也就是电影类型的id--%>
                </c:forEach>
            </td>
        </tr>
        <tr>
            <td colspan="2">
              <input type="submit" value="提交">
            </td>
        </tr>

    </table>

</form>
</body>

</html>
