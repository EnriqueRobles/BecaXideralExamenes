<%@ page import="java.util.*, com.luv2code.web.jdbc.*" %>
<!DOCTYPE html>
<html>

<head>
	<title>Profesor Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<%
	// get the students from the request object (sent by servlet)
	List<Profesor> theProfesor = 
					(List<Profesor>) request.getAttribute("PROFESOR_LIST");
%>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Clase</th>
				</tr>
				
				<% for (Profesor tempProfesor : theProfesor) { %>
				
					<tr>
						<td> <%= theProfesor.getFirstName() %> </td>
						<td> <%= theProfesor.getLastName() %> </td>
						<td> <%= theProfesor.getEmail() %> </td>
						<td> <%= theProfesor.getClase() %> </td>
					</tr>
				
				<% } %>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








