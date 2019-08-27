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

<form method="post" action="toadd">
    <table>
        <tr>
            <td>产品名称</td>
            <td>
                <input type="hidden" name="id" value="${c.id}">
                <input type="text" name="name" value="${c.name}">
            </td>
        </tr>

        <tr>
            <td>数量</td>
            <td><input type="text" name="num" value="${c.num}"></td>
        </tr>
        <tr>
            <td>一级标题</td>
            <td>
                <select name="oid">
                    <c:forEach items="${list}" var="c">
                        <option id="oid" value="${c.oid}" onclick="gettid(${c.oid})">${c.oname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
        <td>二级标题</td>
        <td>
            <select name="tid" id="tid">
            </select>
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
<script>
    $(function () {
        //清空
        $("#tid").empty();
        //页面加载完毕后会获得一个父节点电脑整机,将电脑整机的id查出来.
        var oid = $("#oid").val();
        $.post(
            "gettid",
            {oid: oid},
            function (data) {
                for (var i in data) {
                    //定义一个空字符串
                    var op = "<option value='" + data[i].tid + "'>" + data[i].tname + "</option> ";
                    //给tid追加下拉框
                    $("#tid").append(op);
                }
            },
            "json"
        )
    })

    function gettid(oid) {
        //清空
        $("#tid").empty();
        $.post(
            "gettid",
            {oid: oid},
            function (data) {
                for (var i in data) {
                    //定义一个空字符串
                    var op = "<option value='" + data[i].tid + "'>" + data[i].tname + "</option> ";
                    //给tid追加下拉框
                    $("#tid").append(op);
                }
            },
            "json"
        )
    }


</script>
</html>
