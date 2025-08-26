<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update registration</title>
</head>
<body>
	<h2>Update Registration here....</h2>
	<form action="" method="post">
		<pre>
			<input type="hidden" name="id" value="<%=request.getAttribute("id")%>" readonly/> 
			Name <input type="text" name="name" value="<%=request.getAttribute("name")%>"/>
			Course <input type="text" name="course" value="<%=request.getAttribute("course")%>"/>
			Email <input type="text" name="email" value="<%=request.getAttribute("email")%>"/>
			Mobile <input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/>
			<input type="submit" value="update"/>
		</pre>
	</form>
	
	<%
		if(request.getAttribute("message")!=null){
			out.println(request.getAttribute("message"));
		}
	%>
</body>
</html>
