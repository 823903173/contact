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
<CENTER>
<table border="1">
    <tr>
        <th>组织ID</th>
        <th>部门名称</th>
        <th>部门级别</th>
        <th>部门状态</th>
        <th>创建时间</th>
        <th>创建管理员ID</th>
    </tr>

    <c:forEach items="${contactOrgs}" var="contactOrgs">
        <tr>
            <td>${contactOrgs.id}</td>
            <td>${contactOrgs.name}</td>
            <td>${contactOrgs.level}</td>
            <td>${contactOrgs.status}</td>
            <td>${contactOrgs.createTime}</td>
            <td>${contactOrgs.managerId}</td>
        </tr>
    </c:forEach>
    <br>
    <br>
</table>
</CENTER>

<br>
<br>

<center>
    <a href="/hmcc/ContactUserlogin/toImportExcel.do?phoneNum=${contactNumber}" >返回首页</a></center>
</center>
</body>
</html>