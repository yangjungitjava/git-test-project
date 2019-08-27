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
<title>欢迎${userinfo.uname}同学进入选课系统</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>

<form method="post" action="stuList" name="">
    <input type="button" value="学生添加选课申请" onclick="notcheck()">
    <input type="button" value="查询审核通过的其它学生申请" onclick="AllPassApply()">
    <table>
        <tr>
            <td>课程编号</td>
            <td>课程名称</td>
            <td>审核状态</td>
        </tr>

        <c:forEach items="${list}" var="c">
            <tr>
                <td>${c.cid}</td>
                <td>${c.cname}</td>
                <td>${c.state==0?"审核未通过":c.state==1?"审核通过":"待审核" }
                    <input type="hidden" value="${c.state}" class="show">
                    <input type="hidden" value="${c.cid}">
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>


<script>
    $(function () {
        //为审核未通过的课程添加一个删除的按钮
        $(".show[value=0]").after("<input type='button' value='删除' class='del'/>  ");
        //ajax删除
        $(".del").click(function () {
            //获得当前课程的id
            var cid = $(this).next().val();
            $.post("delstu", {cid: cid}, function (data) {
                alert("删除成功");
                history.go(0);
            }, "json")
        })
    })

    // 学生添加选课申请
    function notcheck() {
        location = "addClazz";
    }

    //查询审核通过的其它学生申请
    function AllPassApply() {
        location = "AllPassApply";
    }


</script>
</html>
