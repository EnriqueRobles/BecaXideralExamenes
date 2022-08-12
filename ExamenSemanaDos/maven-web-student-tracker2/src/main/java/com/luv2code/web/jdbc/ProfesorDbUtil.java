package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ProfesorDbUtil {

	private DataSource dataSource;

	public ProfesorDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}

	public List<Profesor> getProfesor() throws Exception {

		List<Profesor> profesor = new ArrayList<>();

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery("select * from profesor order by clase_impartida");) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String clase = myRs.getString("clase_impartida");

				// create new profesor object
				Profesor tempProfesor = new Profesor(id, firstName, lastName, email, clase);

				// add it to the list of profesores
				profesor.add(tempProfesor);
			}

			return profesor;
		}
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}

			if (myStmt != null) {
				myStmt.close();
			}

			if (myConn != null) {
				myConn.close(); // doesn't really close it ... just puts back in connection pool
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public Profesor getProfesor(String theProfesorId) throws Exception {

		Profesor theProfesor = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int profesorId;
		
		try {
			// convert student id to int
			profesorId = Integer.parseInt(theProfesorId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to get selected student
			String sql = "select * from profesor where id=?";
			
			// create prepared statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, profesorId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set row
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String clase = myRs.getString("clase_impartida");
				
				// use the studentId during construction
				theProfesor = new Profesor(profesorId, firstName, lastName, email,clase);
			}
			else {
				throw new Exception("Could not find student id: " + profesorId);
			}				
			
			return theProfesor;
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, myRs);
		}
	}

	public void addProfesor(Profesor theProfesor) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();

			// create sql for insert
			String sql = "insert into profesor " + "(first_name, last_name, email, clase_impartida) " + "values (?, ?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set the param values for the profesor
			myStmt.setString(1, theProfesor.getFirstName());
			myStmt.setString(2, theProfesor.getLastName());
			myStmt.setString(3, theProfesor.getEmail());
			myStmt.setString(4, theProfesor.getClase());

			// execute sql insert
			myStmt.execute();
		} finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
	
	public void updateProfesor(Profesor theProfesor) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update profesor "
						+ "set first_name=?, last_name=?, email=?, clase_impartida= ? "
						+ "where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theProfesor.getFirstName());
			myStmt.setString(2, theProfesor.getLastName());
			myStmt.setString(3, theProfesor.getEmail());
			myStmt.setString(4, theProfesor.getClase());
			myStmt.setInt(5, theProfesor.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	public void deleteProfesor(String theProfesorId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// convert student id to int
			int profesorId = Integer.parseInt(theProfesorId);
			
			// get connection to database
			myConn = dataSource.getConnection();
			
			// create sql to delete student
			String sql = "delete from profesor where id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, profesorId);
			
			// execute sql statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC code
			close(myConn, myStmt, null);
		}	
	}
}
