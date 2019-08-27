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
<title>欢迎${userinfo.uname}进入学生添加选课申请系统</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>

<form method="post">
    <table>
        <tr>
            <td>课程名称</td>
            <td>
                <select name="cid">
                    <c:forEach items="${list}" var="c">
                        <option value="${c.cid}">${c.cname}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="button" value="提交" onclick="newapply()">
                <input type="hidden" name="uid" value="${us.uid}">
            </td>
        </tr>
    </table>
</form>
</body>


<script>

    function newapply() {

        $.post("addclazz",
            {
                cid: $("[name='cid']").val(),
                uid: $("[name='uid']").val()
            },
            function (data) {
                alert("申请成功");
                history.go(0);
            },
            "json"
        )
    }

</script>


</html>
