<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${emps }
<hr>
${p }
<hr>
<a href="add.jsp">添加</a>
<table>
	
		<tr>
			<td>empno</td>
			<td>ename</td>
			<td>job</td>
			<td>mgr</td>
			<td>hiredate</td>
			<td>sal</td>
			<td>comm</td>
			<td>deptno</td>
			<td>操作</td>
		</tr>
		
	<c:forEach items="${emps }" var="i">
		<tr>
			<td>${i.empno }</td>
			<td>${i.ename }</td>
			<td>${i.job }</td>
			<td>${i.mgr }</td>
			<td>${i.hiredate }</td>
			<td>${i.sal }</td>
			<td>${i.comm }</td>
			<td>${i.deptno }</td>
			<td>
				<a href="selectById?id=${i.empno }">更新</a>
				<a href="delete?empno=${i.empno }">删除</a>
			</td>
		</tr>
	</c:forEach>
	</table>
	总记录数:${p.total } 共:${p.pages }页 当前页${p.pageNum }
	<c:set var="page" value="1"></c:set>
	<c:if test="${p.pageNum-1!=0 }">
		<a href="show?page=${p.pageNum-1 }">上一页</a>
	</c:if>
	<c:forEach begin="1" end="${p.pages }" var="i">
		<a href="show?page=${i }">第${i}页</a>&nbsp;
	</c:forEach>
	<c:if test="${p.pageNum-p.pages!=0 }">
		<a href="show?page=${p.pageNum+1 }">下一页</a>
	</c:if>

</body>
</html>