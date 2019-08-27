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
<form method="post" action="insertGoods" name="">
    <%--<input type="" name="" value="">
    <input type="" value="" onclick="">--%>
    <table>



            <tr>
                <td>商品类型</td>
                <td>
                    <select name="cid">
                    <c:forEach items="${list}" var="s">
                        <option value="${s.cid}">${s.cname}</option>
                    </c:forEach>
                    </select>
                </td>
            </tr>
        <tr>
            <td>
                商品名称
            </td>
            <td>
                <input type="text" name="gname">
            </td>
        </tr>
        <tr>
            <td>
                商品价格
            </td>
            <td>
                <input type="text" name="price">
            </td>
        </tr>

        <tr>
            <td>
                商家
            </td>
            <td>
                <input type="hidden" value="${userinfo.uid}" name="uid">
                <input type="text" name="shangjia">
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
