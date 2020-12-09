<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/6
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="${pageContext.request.contextPath}/method" method="post">
    <input type="submit" value="POST">
  </form>

  <form action="${pageContext.request.contextPath}/param7" method="get">
    id: <input type="text" name="id" > <br>
    age: <input type="text" name="age" > <br>
    name: <input type="text" name="name" > <br>
    phone: <input type="text" name="phone" > <br>
    <%-- 级联属性 --%>
    车牌号: <input type="text" name="car.carNo" > <br>
    车类型: <input type="text" name="car.carType" > <br>
    <input type="submit" value="提交">
  </form>

  </body>
</html>
