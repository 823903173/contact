<%--
  Created by IntelliJ IDEA.
  User: TR
  Date: 2017/10/12
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/main.css" type="text/css" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传文件成功 页面</title>
</head>
<body>
<div align="center">
    <h1>Excel导入成功！</h1>
</div>
<center>
<table border="1">
    <tr>
        <th>管理员ID</th>
        <th>组织ID</th>
        <th>联系方式</th>
        <th>用户状态</th>
        <th>创建时间</th>
        <th>创建管理员ID</th>
    </tr>

    <c:forEach items="${contactAdmins}" var="contactAdmins">
        <tr>
            <td>${contactAdmins.managementNumber}</td>
            <td>${contactAdmins.organizationId}</td>
            <td>${contactAdmins.contactNumber}</td>
            <td>${contactAdmins.state}</td>
            <td>${contactAdmins.createTime}</td>
            <td>${contactAdmins.createAdminId}</td>
        </tr>
    </c:forEach>
</table>
</center>
<br>
<br>

<center>
    <a href="/hmcc/ContactUserlogin/toImportExcel.do?phoneNum=${contactNumber}" >返回首页</a></center>
</center>

</body>
</html>