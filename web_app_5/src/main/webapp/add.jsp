<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Add Numbers</h2>
	<form action="add" method="post">
		Number 1: <input type="text" name="num1"/>
		Number 2: <input type="text" name="num2"/>
		<input type="submit" value="add"/>
	</form>
	
	
</body>

	<%
	
		if(request.getAttribute("result")!=null){
			out.println(request.getAttribute("result"));
		}
	%>

</html>