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
    function selectTwo(oid) {
        //清空之前的二级标题
        $("#tid").empty();
        $.post(
            "selectTwo",
            {oid:oid},/*这个地方的oid是一级结点传过来的*/
            function (data) {
                for(var i in data){
                    var ops="<option value="+data[i].tid+">"+data[i].tname+"</option>";//=后面的"" 要加
                    //给二级标题追加下拉框
                    $("#tid").append(ops);
                }
            },
            "json"
        );
    }
    
   $(function () {
        //清空之前的二级标题
        $("#tid").empty();
        //刷新页面后会获得第一个父级结点
        var oid=$("#oid").val();
        $.post(
            "selectTwo",
            {oid:oid},
            function (data) {
                for(var i in data){
                    var ops="<option value='"+data[i].tid+"'>"+data[i].tname+"</option>";//=后面的"" 要加
                    //给二级标题追加下拉框
                    $("#tid").append(ops);
                }
            },
            "json"
        );
    })

</script>
<form method="post" action="insertComputer" enctype="multipart/form-data">
    <table>
        <tr>
            <td>产品编号</td>
            <td>
                <input type="hidden" name="cid" value="${c.cid}">
                <input type="text" name="ccid" value="${c.ccid}">
            </td>
        </tr>
        <tr>
            <td>产品名称</td>
            <td><input type="text" name="cname" value="${c.cname}"></td>
        </tr>
        <tr>
            <td>数量</td>
            <td><input type="text" name="count" value="${c.count}"></td>
        </tr>

        <tr>
            <td>一级标题</td>
            <td>
                <select name="oid"><%--这个地方的oid就是oid=#{oid}对应的--%>
                    <c:forEach items="${list}" var="o">
                    <option id="oid" value="${o.oid}" onclick="selectTwo(${o.oid})">${o.oname}</option>
                        <%--onclick="selectTwo(${o.oid})"为二级节点传一个一级结点的oid--%>
                        <%--id="oid"这个id属性的作用是用来获得第一个父级结点的--%>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>二级标题</td>
            <td>
                <select name="tid" id="tid">
                </select>
            </td>
        </tr>

        <tr>
            <td>头像</td>
            <td>
               <input type="file" name="multipartFile">
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="提交">
            </td>
        </tr>



    </table>
</form>
</body>
</html>
