<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>empList</title>
</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							2009/11/20
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>empno员工编号</td>
							<td>ename员工名字</td>
							<td>job职位</td>
							<td>sal月新</td>
							<td>comm奖金</td>
							<td>dname部门名称</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${emps }" var="emp">
						<tr class="row1">
							<td>${emp.empno }</td>
							<td><a href="updateview.do?EMPNO=${emp.empno }">${emp.ename }</a></td>
							<td>${emp.job }</td>
							<td>${emp.sal }</td>
							<td>${emp.comm }</td>
							<td>${emp.dept.dname }</td>
<%-- 							<td><a href="<%=request.getContextPath() %>/emp/remove.do?EMPNO=${emp.empno }">delete</a></td> --%>
							<td><a href="remove.do?EMPNO=${emp.empno }">delete</a></td>
						</tr>
						</c:forEach>
					</table>
					<p>
						<input type="button" class="button" value="Add User" onclick="location='addview.do'"/>
					</p>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
