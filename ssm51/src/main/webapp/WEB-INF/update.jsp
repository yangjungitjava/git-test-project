<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/15
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
    <link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>
<table>
<form action="updateUser" method="post" >
    <tr>
        <td>账号</td>
        <td>
            <input type="hidden" name="id" value="${i.id}">
            <input type="text" name="zhanghao" value="${i.zhanghao}">
        </td>
    </tr>
    <tr>
        <td>真实姓名</td>
        <td><input type="text" name="name" value="${i.name}"></td>
    </tr>
    <tr>
        <td>用户年龄</td>
        <td><input type="text" name="age" value="${i.age}"></td>
    </tr>
    <tr>
        <td>部门</td>
        <td><input type="text" name="department" value="${i.department}"></td>
    </tr>
    <tr>
        <td>爱好</td>
        <td>
            <input type="checkbox" name="hobby" <c:if test="${fn:contains(i.hobby, '吃')}">checked</c:if> value="吃">吃
            <input type="checkbox" name="hobby" <c:if test="${fn:contains(i.hobby, '喝')}">checked</c:if> value="喝">喝
            <input type="checkbox" name="hobby" <c:if test="${fn:contains(i.hobby, '玩')}">checked</c:if> value="玩">玩
            <input type="checkbox" name="hobby" <c:if test="${fn:contains(i.hobby, '乐')}">checked</c:if> value="乐">乐
        </td>
    </tr>
    <tr>
        <td>注册时间</td>
        <td><input type="text" name="time" value="${i.time}"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交">
        </td>
    </tr>
</form>
</table>
</body>
</html>
