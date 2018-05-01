<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/style.css" />
<title>addemp</title>
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
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						add User info:
					</h1>
					<form action="add.do" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									empno员工编号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="EMPNO" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									ename员工姓名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="ENAME" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									job职位:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="JOB" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									sal月新:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="SAL" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									comm奖金:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="COMM" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									dname部门名称:
								</td>
								<td valign="middle" align="left">
									<select name="DEPTNO">
										<c:forEach items="${deptList }" var="dept">
										<option value="${dept.deptno }">${dept.dname }</option>
										</c:forEach>
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
						</p>
					</form>
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
