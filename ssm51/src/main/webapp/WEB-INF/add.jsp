<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/15
  Time: 11:13
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
    function unique(){
        $.post("unique",$("form").serialize(),function (data) {
            if(data){
                alert("该用户已存在");
            }
        },"json");
    }
</script>
<body>
<table>
    <form method="post" enctype="multipart/form-data" action="toadd">
        <tr>
            <td>账号</td>
            <td>
                <input type="text" name="zhanghao" onchange="unique()">
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
            <td>
                <select name="department">
                    <c:forEach items="${list}" var="l">
                        <option value="${l.cid}">${l.cname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>爱好</td>
            <td><input type="checkbox" name="hobby" value="吃">吃
                <input type="checkbox" name="hobby" value="喝">喝
                <input type="checkbox" name="hobby" value="玩">玩
                <input type="checkbox" name="hobby" value="乐">乐
            </td>
        </tr>
        <tr>
            <td>注册时间</td>
            <td><input type="date" name="time"></td>
        </tr>
        <tr>
            <td>头像</td>
            <td><input type="file" name="multipartFile"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>
    </form>
</table
</body>
</html>
