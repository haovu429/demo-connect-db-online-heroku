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
    <title> Java Ajax File Upload Example </title>
</head>
<body>
<!-- HTML5 Input Form Elements -->
<input id="ajaxfile" type="file"/> <br/>
<button onclick="uploadFile()"> Upload</button>

<!-- Ajax to Java File Upload Logic -->
<script>
    async function uploadFile() {
        let formData = new FormData();
        formData.append("file", ajaxfile.files[0]);
        await fetch('fileuploadservlet', {
            method: "POST",
            body: formData
        });
        alert('The file upload with Ajax and Java was a success!');
    }
</script>

<form method="post" action="<%=request.getContextPath()%>/fileuploadservlet" enctype="multipart/form-data" >
    Choose a file: <input type="file" name="multiPartServlet" multiple="multiple"/>
    <input type="submit" value="Upload" />
</form>
</body>
</html>
