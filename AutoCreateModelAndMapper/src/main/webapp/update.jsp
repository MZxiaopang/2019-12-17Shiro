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
<form action="update">

	empno:<input type="text" id="readonly" readonly="readonly" name="empno" value="${emp.empno }" ><br>
	ename:<input type="text" name="ename" value="${emp.ename }"><br>
	job:<input type="text" name="job" value="${emp.job }"><br>
	mgr:<input type="text" name="mgr" value="${emp.mgr }"><br>
	hiredate:<input type="date" name="hiredate" value="${emp.hiredate }"><br>
	sal:<input type="text" name="sal" value="${emp.sal }"><br>
	comm:<input type="text" name="comm" value="${emp.comm }"><br>
	deptno:<input type="text" name="deptno" value="${emp.deptno }"><br>
	<input type="submit" value="修改">

</form>


</body>
</html>