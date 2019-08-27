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
                    $.post("xl",null,function (data) {
                        for(var i in data){
                            var ops="<option value='"+data[i].cid+"'>"+data[i].cname+"</option>"
                            $("#cid").append(ops);
                        }
                    },"json")

                </script>
<form method="post" action="insert" enctype="multipart/form-data">

    <table>
        <tr>
            <td>类型</td>
            <td>
                <select name="cid" id="cid">
                </select>
            </td>
        </tr>
        <tr>
            <td>名称</td>
            <td><input type="text" name="name"></td>
        </tr>

 <tr>
            <td>简介</td>
            <td><input type="text" name="content"></td>
        </tr>

 <tr>
            <td>单价</td>
            <td><input type="text" name="price"></td>
        </tr>

 <tr>
            <td>起始时间</td>
            <td><input type="date" name="qtime"></td>
        </tr>

        <tr>
            <td>更新时间</td>
            <td><input type="date" name="gtime"></td>
        </tr>
        <tr>
            <td>头像上传</td>
            <td><input type="file" name="multipartFile"></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="添加">
            </td>
        </tr>





    </table>
</form>
</body>
</html>
