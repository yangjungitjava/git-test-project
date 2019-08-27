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
<title>学生添加选课申请记录</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>
<form method="post">

    <table>
        <tr>
            <td>课程名称</td>
        </tr>


        <tr>
            <td>
                <select>
                    <c:forEach items="${list}" var="s">
                        <option value="${s.cid}">"${s.cname}"</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

    </table>
</form>
</body>
</html>
