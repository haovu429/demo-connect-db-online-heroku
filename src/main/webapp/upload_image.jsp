<%--
  Created by IntelliJ IDEA.
  User: caiho
  Date: 11/9/2022
  Time: 5:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title> Java File Upload Servlet Example </title>
</head>
<body>

<form method="post" action="<%=request.getContextPath()%>/fileuploadservlet" enctype="multipart/form-data">
  <input type="file" name="file" />
  <input type="submit" value="Upload" />
</form>

<form>

</form>

</body>
</html>
