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

<form method="post" action="" name="">
    <%--<input type="" name="" value="">
    <input type="" value="" onclick="">--%>
    <table>
        <tr>
            <td>电影</td>
            <td>
                <input type="hidden" name="id" value="${m.id}">
                <input type="text" name="name" value="${m.name}" readonly="readonly">
            </td>
        </tr>
        <tr>
            <td>作者</td>
            <td><input type="text" name="author" value="${m.author}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>类型</td>
            <td><input type="text" name="type" value="${m.type}" readonly="readonly"></td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea readonly="readonly" cols="90" rows="30" value="${m.discrete}">
                    ${m.discrete}
                </textarea>
            <td>
        </tr>
    </table>
        <center>
            <input type="button" value="好评" onclick="good(${m.id})">
            <input type="button" value="差评" onclick="bad(${m.id})">
        </center>
</form>
</body>
            <script>
                //好评
                function good(id) {
                    location="level?id="+id+"&level=good";
                }
                //差评
                function bad(id) {
                    location="level?id="+id+"&level=bad";
                }
            </script>
</html>
