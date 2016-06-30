<%--
  Created by IntelliJ IDEA.
  User: wang_zhao
  Date: 2016/6/30
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%--@elvariable id="order" type="com.gentlemen.easybuy.entity.Orders"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <script type="text/javascript" src="//cdn.bootcss.com/jquery/3.0.0/core.js"></script>
    <title>test-cart</title>
</head>
<body>
<table>
  <tbody>
  <c:forEach begin="0" end="${fn:length(cartInfo)}" items="order">
      <tr>
          <td>${order.gid}<a id="delete">delete</a></td>
      </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
