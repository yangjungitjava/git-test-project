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
    function go(num) {
        document.cha.page.value=+num;
        document.cha.submit();
    }
    function xun() {
        document.cha.page.value='1';
        document.cha.submit();
    }
    function plsc() {
        var cks=$(".ck:checked");
        if(cks.length<1){
            alert("请至少选一个");
        }else{
            var ids="";
            cks.each(function () {
                ids+=","+this.value;
            });
            ids=ids.substring(1);
            if(confirm("您确定要删除么?")){
                $.post("plsc",{ids:ids},function (data) {
                    alert("删除成功");
                    if(data>0){
                        alert("删除成功");
                        window.location.href="list";
                    }
                },
                "json")
            }

        }
    }
    function add() {
        location="xl";
    }

</script>
<form method="post" action="" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    <input type="hidden" name="page">
    <input type="submit" value="搜索" onclick="xun()">
    <table>
        <tr>
            <td>
                <input  type="button" value="批量删除" onclick="plsc()">
            </td>
            <td>课程编号</td>
            <td>客户名称</td>
            <td>名称</td>
            <td>签订时间</td>
            <td>期限</td>
            <td>预计完成时间</td>
            <td>备注</td>
            <td>
                <input type="button" value="添加" onclick="add()">
            </td>
        </tr>

        <c:forEach items="${pageInfo.list}" var="o">
            <tr>
                <td>
                    <input type="checkbox" class="ck" value="${o.oid}">
                </td>
                <td>${o.oid}</td>
                <td>${o.oname}</td>
                <td>${o.cname}</td>
                <td>${o.qtime}</td>
                <td>${o.qixian}</td>
                <td>${o.ytime}</td>
                <td>${o.beizhu}</td>

            </tr>
        </c:forEach>
    </table>
    当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录.
    <button onclick="go('1')">首页</button>
    <button onclick="go('${pageInfo.prePage}')">上一页</button>
    <button onclick="go('${pageInfo.nextPage}')">下一页</button>
    <button onclick="go('${pageInfo.pages}')">尾页</button>

</form>
</body>
</html>
