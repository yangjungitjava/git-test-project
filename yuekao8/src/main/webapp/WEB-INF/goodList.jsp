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
<script>
    //分页
    function go(num) {
        document.cha.page.value=+num;
        document.cha.submit();
    }
    function xun() {
        document.cha.page.value='1';
        document.cha.submit();
    }
    //商家发布商品
    function add() {
        location="SelectGoods";
    }
</script>
<body>
<span>商家${userinfo.uname}：列表展示自己发布商品</span>
<form method="post" action="goodList" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    <input type="hidden" name="page">
    <input type="submit" value="提交" onclick="xun()">
    <table>
        <tr>
            <td>商品编号</td>
            <td>商品名称</td>
            <td>商品价格</td>
            <td>发布时间</td>
            <td>商家</td>
            <td>商品类型</td>
            <td>
                <input type="button" value="发布商品" onclick="add()">
            </td>
        </tr>

        <c:forEach items="${pageInfo.list}" var="g">
            <tr>
                <td>${g.gid}</td>
                <td>${g.gname}</td>
                <td>${g.price}</td>
                <td>${g.gtime}</td>
                <td>${g.shangjia}</td>
                <td>${g.cname}</td>
                <td>
                    <input type="button" value="修改" onclick="">
                </td>
            </tr>
        </c:forEach>
    </table>
</form>        当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录.
                            <button onclick="go('1')">首页</button>
                            <button onclick="go('${pageInfo.prePage}')">上一页</button>
                            <button onclick="go('${pageInfo.nextPage}')">下一页</button>
                            <button onclick="go('${pageInfo.pages}')">尾页</button>
</body>
</html>
