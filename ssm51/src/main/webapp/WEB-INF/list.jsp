<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/6/14
  Time: 21:27
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
            //分页
            function page(num) {
                document.cha.page.value=num;
                document.cha.submit();
            }
            function xun() {
                document.cha.page.value='1';
                document.cha.submit();
            }
            function qx() {
                $(".ck").each(function () {
                    $(this).attr("checked",true);
                })
            }
            function qbx() {
                $(".ck").each(function () {
                    $(this).attr("checked",false);
                })
            }
            function fx() {
                $(".ck").each(function () {
                    $(this).attr("checked",!$(this).attr("checked"));
                })
            }
            //批量删除
            function plsc() {
                if (confirm("确定删除么")){
                    //定义一个空字符串
                    var ids="";
                    //获取所有选中的复选框
                    var cks=$(".ck:checked");
                    cks.each(function () {
                        ids+=","+this.value;
                    });
                    ids=ids.substring(1);
                    location="plsc?ids="+ids;
                }
            }
            function update(id) {
                location="selectById?id="+id;
            }
        </script>
<body>
<table>
    <form action="list" method="post" name="cha">
        <input type="text" name="mohu" value="${mohu}">
        日期:<input type="text" name="time" value="${time}">
        <input type="hidden" name="page">
        <input type="submit" value="搜索" onclick="xun()">
    <tr>
        <td>
            <input type="button" value="全选" onclick="qx()">
            <input type="button" value="全不选" onclick="qbx()">
            <input type="button" value="反选" onclick="fx()">
            <input type="button" value="批量删除" onclick="plsc()">
        </td>
        <td>编号</td>
        <td>账号</td>
        <td>真实姓名</td>
        <td>用户年龄</td>
        <td>部门</td>
        <td>爱好</td>
        <td>注册时间</td>
        <td>头像</td>
    </tr>
    <c:forEach items="${pageInfo.list}" var="l">
       <tr>
           <td>
               <input type="checkbox" class="ck" value="${l.id}">
           </td>
           <td>${l.id}</td>
           <td>${l.zhanghao}</td>
           <td>${l.name}</td>
           <td>${l.age}</td>
           <td>${l.cname}</td>
           <td>${l.hobby}</td>
           <td>${l.time}</td>
           <td>
               <img src="${l.img}">
           </td>
           <td>
               <input type="button" value="修改" onclick="update(${l.id})">
           </td>
       </tr>
    </c:forEach>
</form>
</table>
当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录.
<button onclick="page('1')">首页</button>
<button onclick="page('${pageInfo.prePage}')">上一页</button>
<button onclick="page('${pageInfo.nextPage}')">下一页</button>
<button onclick="page('${pageInfo.pages}')">尾页</button>
</body>
</html>
