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
<title>欢迎${userinfo.uname}管理员进入学生选课系统</title>
<script type="text/javascript" src="jquery/jquery-1.8.2.js"></script>
<link rel="stylesheet" href="css/css.css" type="text/css"></link>
</head>
<body>


<table>
    <tr>
        <td>学生姓名</td>
        <td>课程姓名</td>
        <td>审核状态</td>
    </tr>

    <c:forEach items="${list}" var="s">
        <tr>
            <td>${s.uname}</td>
            <td>${s.cname}</td>
            <td>${s.state==0?"审核未通过":s.state==1?"审核通过":"待审核"}
                <input type="hidden" value="${s.uid}">
                <input type="hidden" value="${s.state}" class="checkclazz">
                <input type="hidden" value="${s.cid}">
            </td>
        </tr>
    </c:forEach>
</table>
<form id="checkclazz">

</form>
</body>

<script>
    $(function () {
        //为未审核的课程添加一个审核按钮
        $(".checkclazz[value=2]").after("<input type='button' value='审核' class='show' >  ")
        $(".show").click(function () {//是click而不是onclik
            //清空表单数据
            $("form").empty();
            //根据cid和state来审核课程信息
            //获取cid
            var cid = $(this).next().val();
            //获取uid
            var uid = $(this).prev().prev().val();
            $("form").append("<input type='hidden' value='" + cid + "' name='cid'> ");
            $("form").append("<input type='hidden' value='" + uid + "' name='uid'> ");
            $("form").append("<input type='radio' name='state' value='0'>" + '不通过' + " ");
            $("form").append("<input type='radio' name='state' value='1'>" + '通过' + "");
            $("form").append("<input type='button' value='提交' onclick='tj()'>")
        })
    })

    //审核
    function tj() {
        $.post("checkClazz", $("form").serialize(), function (data) {
            alert("审核成功");
            history.go(0);
        }, "json")
    }


</script>
</html>
