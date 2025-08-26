<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="menu.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<h2> Register here..........</h2>
<form action="registrationController" method="post">
		<pre>
			Name <input type="text" name="name"/>
			Course <input type="text" name="course"/>
			Email <input type="text" name="email"/>
			Mobile <input type="text" name="mobile"/>
			<input type="submit" value="register"/>
		</pre>
	</form>


</body>
</html>