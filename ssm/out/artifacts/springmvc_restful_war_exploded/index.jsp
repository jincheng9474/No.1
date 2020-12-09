<%--
  Created by IntelliJ IDEA.
  User: 12069
  Date: 2020/11/9
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
        <a href="${pageContext.request.contextPath}/book/1">查询1的图书</a><br>
        <a href="${pageContext.request.contextPath}/book">查询全部图书</a><br>
        <form action="${pageContext.request.contextPath}/book" method="post">
            <input type="submit" value="添加图书">
        </form>

        <%--
            restful风格发送PUT请求，和DELETE请求，需要按以下几个步骤操作：
          1 先有一个post请求的表单
          2 有隐藏域 _method = PUT | DELETE
              <input type="hidden" name="_method" value="PUT" /> 表示 PUT 请求
              <input type="hidden" name="_method" value="DELETE" /> 表示 DELETE 请求
          3 添加将参数转换为请求方式的Filter过滤器 HiddenHttpMethodFilter
        --%>
        <form action="${pageContext.request.contextPath}/book/1" method="post">
            <input type="hidden" name="_method" value="PUT">
            <input type="submit" value="修改图书">
        </form>

        <form action="${pageContext.request.contextPath}/book/1" method="post">
            <input type="hidden" name="_method" value="DELETE">
            <input type="submit" value="删除图书">
        </form>
  </body>
</html>
