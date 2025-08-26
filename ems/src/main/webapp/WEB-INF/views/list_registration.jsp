<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<table>
		<tr>
			<th>
				Id
			</th>
			<th>
				Name
			</th>
			<th>
				Course
			</th>
			<th>
				Email
			</th>
			<th>
				Mobile
			</th>
			<th>
				Delete
			</th>
			<th>
				update
			</th>
		</tr>
		
		<%
			ResultSet result =(ResultSet)request.getAttribute("registrations");
			while(result.next()){%>
			<tr>
			<td>
				<%=result.getInt(1)%>
			</td>
			<td>
				<%=result.getString(2)%>
			</td>
			<td>
				<%=result.getString(3)%>
			</td>
			<td>
				<%=result.getString(4)%>
			</td>
			<td>
				<%=result.getString(5)%>
			</td>
			
			<td>
				<a href="deleteReg?email=<%=result.getString(4)%>">delete</a>
			</td>
			<td>
				<a href="updateReg?id=<%=result.getString(1)%>">update</a>
			</td>
			
			
		</tr>
			
				
		<%} %>	
		
		
		
	</table>
</body>
</html>
