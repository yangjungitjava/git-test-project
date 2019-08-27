<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jun
  Date: 2019/5/19
  Time: 20:39
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
                function go(num) {
                    document.cha.page.value=+num;
                    document.cha.submit();
                }
             //全选
                function qx() {
                    $(".ck").each(function () {
                        $(this).attr("checked",true);
                    })
                }
                //批量删除
                function plsc() {
                    //定义一个空字符串
                    var ids="";
                    //获取所有选中的复选框
                    var cks=$(".ck:checked");
                    if (confirm("您确定要删除么")){
                        cks.each(function () {
                            ids+=","+this.value;
                        });
                        ids=ids.substring(1);
                        location="plsc?ids="+ids;
                    }

                }
                function add() {
                    location="selectcolor";
                }
            </script>
<body>
    <form action="list" name="cha" method="post">
        <input type="hidden" name="page">
        <table>
            <tr>
                <td><input type="button" value="全选" onclick="qx()">
                    <input type="button" value="批量删除" onclick="plsc()">
                </td>
                <td>编号</td>
                <td>商品名称</td>
                <td>单价</td>
                <td>单位</td>
                <td>店铺名称</td>
                <td>品牌名称</td>
                <td>颜色</td>
                <td>数量</td>
                <td><input type="button" value="添加" onclick="add()"></td>
            </tr>

            <c:forEach items="${pageInfo.list}" var="p">
                <tr>
                    <td><input type="checkbox" class="ck" value="${p.id}"></td>
                    <td>${p.id}</td>
                    <td>${p.pro_name}</td>
                    <td>${p.price}</td>
                    <td>${p.unit}</td>
                    <td>${p.sname}</td>
                    <td>${p.bname}</td>
                    <td>${p.tname}</td>
                    <td>${p.quantity}</td>
                </tr>
            </c:forEach>
        </table>
    </form>
        当前${pageInfo.pageNum}/${pageInfo.pages}页,共${pageInfo.total}条记录.
        <button onclick="go('1')">首页</button>
        <button onclick="go('${pageInfo.prePage}')">上一页</button>
        <button onclick="go('${pageInfo.nextPage}')">下一页</button>
        <button onclick="go('${pageInfo.pages}')">尾页</button>

</body>
</html>
