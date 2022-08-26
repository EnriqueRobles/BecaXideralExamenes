<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista Profesores</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Listado General Profesores</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Profesor -->
		
			<input type="button" value="Agregar Profesor"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Clase Impartida</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempProfesor" items="${profesor}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/profesor/showFormForUpdate">
						<c:param name="profesorId" value="${tempProfesor.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/profesor/delete">
						<c:param name="profesorId" value="${tempProfesor.id}" />
					</c:url>					
					
					<!-- Campos que van a leer la info de la BD -->
					<tr>
						<td> ${tempProfesor.firstName} </td>
						<td> ${tempProfesor.lastName} </td>
						<td> ${tempProfesor.email} </td>
						<td> ${tempProfesor.claseImpartida} </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Deseas eliminar este profesor?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









