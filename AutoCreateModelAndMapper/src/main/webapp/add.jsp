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
<form action="add">

	ename:<input type="text" name="ename" ><br>
	job:<input type="text" name="job" ><br>
	mgr:<input type="text" name="mgr" ><br>
	hiredate:<input type="date" name="hiredate" ><br>
	sal:<input type="text" name="sal"><br>
	comm:<input type="text" name="comm" ><br>
	deptno:<input type="text" name="deptno" ><br>
	<input type="submit" value="添加">

</form>


</body>
</html>