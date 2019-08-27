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
//添加
    function add() {
        window.location.href="selectOne";
    }
    //修改
    function toupdateCom(cid) {
        window.location.href="toupdateCom?cid="+cid;
    }
    //删除
    function delCom(cid) {
        window.location.href="delCom?cid="+cid;
    }
    //全选
    function qx() {
        $(".ck").each(function () {
            $(this).attr("checked",true);
        })
    }
    //全不选
    function qbx() {
        $(".ck").each(function () {
            $(this).attr("checked",false);
        })
    }
    //反选
    function fx() {
        $(".ck").each(function () {
            $(this).attr("checked", !$(this).attr("checked"));
        })
    }
    //批量删除
    function plsc() {
        //获取所有选中的复选框
        var cks=$(".ck:checked");
        //定义一个空字符串
        var ids="";
        if(cks.length<1){
            alert("请至少选一个")
        }else {
            if(confirm("您确定要删除么?")){
            //对所有选中的复选框进行遍历
            cks.each(function () {
                ids+=","+this.value;
            })
            alert("删除成功");
            ids=ids.substring(1);
            window.location.href="plsc?ids="+ids;
        }
        }
    }
    //分页
    function go(num) {
        document.cha.page.value=+num;//不能写成document.page.cha.value
        document.cha.submit();
    }
    function xun() {
        document.cha.page.value='1';
        document.cha.submit();
    }
</script>
<form method="post" action="list" name="cha">
    <input type="text" name="mohu" value="${mohu}">
    <input type="hidden" name="page">
    <input type="submit" name="搜索" onclick="xun()">
    <table>
        <tr>
            <td>
                <input type="button" value="全选" onclick="qx()">
                <input type="button" value="全不选" onclick="qbx()">
                <input type="button" value="反选" onclick="fx()">
                <input type="button" value="批量删除" onclick="plsc()">
            </td>
            <td>产品编号</>
            <td>产品名称</td>
            <td>一级类别</td>
            <td>二级类别</td>
            <td>数量</td>
            <td>头像</td>
            <td><input type="button" value="添加" onclick="add()"></td>
        </tr>

        <c:forEach   items="${pageInfo.list}" var="c">
            <tr>
                <td>
                    <input type="checkbox" class="ck" value="${c.cid}">
                </td>
                <td>${c.ccid}</td>
                <td>${c.cname}</td>
                <td>${c.oname}</td>
                <td>${c.tname}</td>
                <td>${c.count}</td>
                <td>
                    <%--头像上传固定使用img标签--%>
                    <img src="${c.img}">
                </td>
                <td><input type="button" value="修改" onclick="toupdateCom('${c.cid}')"></td>
                <td><input type="button" value="删除" onclick="delCom('${c.cid}')"></td>
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
