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
<form method="post" action="login" name="">
    <%--<input type="" name="" value="">
    <input type="" value="" onclick="">--%>
    <span style="color: red">${info}</span>
    <table>

        <tr>
           <td>用户名</td>
           <td><input type="text" name="cname"></td>
        </tr>
 <tr>
           <td colspan="2">
               <input type="submit" value="登录">
           </td>
        </tr>


    </table>
</form>
</body>
</html>
