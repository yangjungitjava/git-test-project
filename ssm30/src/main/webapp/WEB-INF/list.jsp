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
<script>
//列表页面中，如果分数小于零，用红色显示分数
   $(function () {
       $(".score").each(function () {//用each函数遍历判断所有的分数
           if($(this).val()<0){
               $(this).next("span").css("color","red");
           }
       })
   })
    //删除
    function del(id) {
        location="delMovie?id="+id;
    }
    //添加
    function add() {
        location="insertMovie";
    }
</script>
<form method="post" action="list" name="">
    <%--<input type="" name="" value="">
    <input type="" value="" onclick="">--%>
    <table>
        <tr>
            <td>编号</td>
            <td>电影</td>
            <td>作者</td>
            <td>类型</td>
            <td>分数</td>
            <td>
                <input type="button" value="添加" onclick="add()">
            </td>
        </tr>

        <c:forEach items="${list}" var="m">
            <tr>
                <td>${m.id}</td>
                <td>
                        <a href="movie?id=${m.id}">${m.name}</a>
                </td>
                <td>${m.author}</td>
                <td>${m.type}</td>
                <td>
                    <input type="hidden" value="${m.score}" class="score">
                     <span>${m.score}</span>
                    <%--${m.score>0?"及格":"不及格"}--%>
                </td>
                <td>
                    <input type="button" value="删除" onclick="del('${m.id}')">
                </td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
