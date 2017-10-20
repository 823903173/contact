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

<table border="1">
		<tr>
			<th>ICCID</th>
			<th>号码</th>
			<th>IMSI</th>
			<th>卡状态</th>
			<th>套餐</th>
			<th>品名</th>
			<th>型号</th>
			<th>安装企业</th>
		</tr>
		
		<c:forEach items="${sSims}" var="sSim">
			<tr>
				<td>${sSim.ccid}</td>
				<td>${sSim.sim}</td>
				<td>${sSim.imsi}</td>
				<td>${sSim.status}</td>
				<td>${sSim.combo}</td>
				<td>${sSim.name}</td>
				<td>${sSim.type}</td>
				<td>${sSim.eId}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>