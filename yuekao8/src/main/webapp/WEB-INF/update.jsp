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
<%--<script>

</script>--%>
<form method="post" action="update" name="">
    <%--<input type="" name="" value="">
    <input type="" value="" onclick="">--%>
    <table>
        <tr>
           <td>商品名称</td>
           <td>
               <input type="hidden" name="gid">
               <input type="text" name="gname">
           </td>
        </tr>

       <tr>
           <td>价格</td>
           <td><input type="text" name="price"></td>
        </tr>

       <tr>
           <td>时间</td>
           <td><input type="text" name="gtime"></td>
        </tr>

       <tr>
           <td colspan="2">
             <input type="submit" value="修改">
           </td>
        </tr>



    </table>
</form>
</body>
</html>
