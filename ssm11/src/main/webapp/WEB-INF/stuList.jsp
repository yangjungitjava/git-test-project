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
<title>学生选课列表</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>

<form method="post" name="">
    <input type="button" onclick="otherstu()" value="审核通过的其它学生的选课申请">
    <input type="button" value="学生添加选课申请记录" onclick="notchoose()">
    <table>
        <tr>
            <td>课程编号</td>
            <td>课程名称</td>
            <td>审核状态</td>
        </tr>

        <c:forEach items="${list}" var="s">
            <tr>
                <td>${s.cid}</td>
                <td>${s.cname}</td>
                <td>${s.state==0?"审核未通过":s.state==1?"审核通过":"未审核" }
                    <input type="hidden" value="${s.state}" class="show">
                    <input type="hidden" value="${s.cid}"><%--这里var="s"要注意不要写错了--%>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>

<script>
    //审核通过的其它学生的选课申请
    function otherstu() {
        location = "otherstu";
    }

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

    //学生添加选课申请记录
    function notchoose() {
        location = "addclazz";
    }


</script>
</html>
