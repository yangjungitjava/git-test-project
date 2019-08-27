<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/17
  Time: 9:54
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
<center><span style="color: black">价格调整</span></center>
<body>
<script>
           function tj() {
               alert("调整成功");
               $.post("updateGood",$("form").serialize(),function (data) {
                   if(data){
                       alert("调整成功");
                       location="list";
                   }
               },"json")
            }
</script>
<table>
<form action="updateGood" method="post">
    <tr>
        <td>商品编号</td>
        <td>
            <input type="hidden" name="id" value="${g.id}">
            <input type="text" name="gid" value="${g.gid}" readonly="readonly"></td>
    </tr>
    <tr>
        <td>商品名称</td>
        <td><input type="text" name="gname" value="${g.gname}" readonly="readonly"></td>
    </tr>
    <tr>
        <td>品牌（中文)</td>
        <td><input type="text" name="cbrand" value="${g.cbrand}" readonly="readonly"></td>
    </tr>
    <tr>
        <td>品牌</td>
        <td><input type="text" name="brand" value="${g.brand}" readonly="readonly"></td>
    </tr>
    <tr>
        <td>尺寸</td>
        <td><input type="text" name="size" value="${g.size}" readonly="readonly"></td>
    </tr>
    <tr>
        <td>价格</td>
        <td><input type="text" name="price" value="${g.price}"></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="button" value="提交" onclick="tj()">
        </td>
    </tr>
</form>
</table>
</body>
</html>
