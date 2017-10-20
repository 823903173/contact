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
<table border="1" >
    <tr>
        <th>用户ID</th>
        <th>用户名</th>
        <th>性别（1（男）/0（女））</th>
        <th>组织ID</th>
        <th>用户职位</th>
        <th>手机号</th>
        <th>是否隐藏</th>
        <th>用户级别</th>
        <th>用户状态</th>
        <th>建立时间</th>
        <th>建立管理员</th>
    </tr>

    <c:forEach items="${contactUsers}" var="contactUsers">
        <tr>
            <td>${contactUsers.userId}</td>
            <td>${contactUsers.userName}</td>
            <td>${contactUsers.userGender}</td>
            <td>${contactUsers.groupId}</td>
            <td>${contactUsers.userJob}</td>
            <td>${contactUsers.phoneNum}</td>
            <td>${contactUsers.isHidden}</td>
            <td>${contactUsers.userPosition}</td>
            <td>${contactUsers.userStatus}</td>
            <td>${contactUsers.createTime}</td>
            <td>${contactUsers.createManagerId}</td>
        </tr>
    </c:forEach>
</table>
</center>
<br>
<br>
<center>
<a href="/hmcc/ContactUserlogin/toImportExcel.do" >返回首页</a></center>
</body>
</html>