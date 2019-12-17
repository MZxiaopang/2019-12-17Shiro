<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="add">添加</a>
	<table>
		<tr>
			<td>id</td>
			<td>password</td>
			<td>name</td>
			<td>age</td>
			<td>操作</td>
		</tr>
		<c:if test="${!empty users}">
			 <tr>
				<c:forEach  begin="0" end="${users.size()-1}" var="i">
					<tr>
						<td>${users[i].id}</td>
						<td>${users[i].password}</td>
						<td>${users[i].username}</td>
					
						<td><a href="selectById?id=${users[i].id}">✎</a>
							<a href="delete?id=${users[i].id}">X</a>
						</td>
					</tr>
				</c:forEach>
			</tr>
		</c:if> 
	</table>


</body>
</html>