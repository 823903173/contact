<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件成功 页面</title>
</head>
<body>
<div align="center">
<h1>Excel导入失败</h1>
</div>
<br>
<br>
<center>
    <a href="/hmcc/ContactUserlogin/toImportExcel.do?phoneNum=${contactAdmins.contactNumber}" >返回首页</a></center>
</center>
</body>
</html>