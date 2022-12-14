<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Student Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Profesor -->
			
			<input type="button" value="Add profesor" 
				   onclick="window.location.href='add-profesor-form.jsp'; return false;"
				   class="add-student-button"
			/>
			
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Clase</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempProfesor" items="${PROFESOR_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="ProfesorControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="profesorId" value="${tempProfesor.id}" />
					</c:url>

					<!--  set up a link to delete a student -->
					<c:url var="deleteLink" value="ProfesorControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="profesorId" value="${tempProfesor.id}" />
					</c:url>
																		
					<tr>
						<td> ${tempProfesor.firstName} </td>
						<td> ${tempProfesor.lastName} </td>
						<td> ${tempProfesor.email} </td>
						<td> ${tempProfesor.clase} </td>
						<td> 
							<a href="${tempLink}">Update</a> 
							 | 
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this profesor?'))) return false">
							Delete</a>	
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








