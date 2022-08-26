package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProfesorDAOJDBC implements ProfesorDAO {
	// se obtiene la direccion a conectarse
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// metodos implementacion
	@Override
	public List<Profesor> findAll() {
		System.out.println("Entra por JDBC: " + dataSource);
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return profesor;
	}

	@Override
	public Profesor findById(int theId) {

		Profesor theProfesor = null;
		int profesorId = theId;

		// create sql to get selected profesor
		String sql = "select * from Profesor where id=?";

		try (Connection myConn = dataSource.getConnection(); PreparedStatement myStmt = myConn.prepareStatement(sql);) {
			// set params
			myStmt.setInt(1, profesorId);

			try (ResultSet myRs = myStmt.executeQuery();) {
				// retrieve data from result set row
				if (myRs.next()) {
					String firstName = myRs.getString("first_name");
					String lastName = myRs.getString("last_name");
					String email = myRs.getString("email");
					String clase = myRs.getString("clase_impartida");

					// use the studentId during construction
					theProfesor = new Profesor(profesorId, firstName, lastName, email, clase);
					return theProfesor;
				} else {
					throw new Exception("Could not find student id: " + profesorId);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return theProfesor;
	}

	@Override
	public void save(Profesor theProfesor) {
		// update
		if (theProfesor.getId() != 0) {
			System.out.println("Entra Update");
			// create SQL update statement
			String sql = "update Profesor " + "set first_name=?, last_name=?, email=?, clase_impartida= ? "
					+ "where id=?";
			try (Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement(sql);) {
				// set params
				myStmt.setString(1, theProfesor.getFirstName());
				myStmt.setString(2, theProfesor.getLastName());
				myStmt.setString(3, theProfesor.getEmail());
				myStmt.setString(4, theProfesor.getClaseImpartida());
				myStmt.setInt(5, theProfesor.getId());

				// execute SQL statement
				myStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Entra ADD");
			// create sql for insert
			String sql = "insert into profesor " + "(first_name, last_name, email, clase_impartida) "
					+ "values (?, ?, ?, ?)";
			try (Connection myConn = dataSource.getConnection();
					PreparedStatement myStmt = myConn.prepareStatement(sql);) {

				// set the param values for the profesor
				myStmt.setString(1, theProfesor.getFirstName());
				myStmt.setString(2, theProfesor.getLastName());
				myStmt.setString(3, theProfesor.getEmail());
				myStmt.setString(4, theProfesor.getClaseImpartida());

				// execute sql insert
				myStmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteById(int theId) {
		System.out.println("Entra a Delete ");
		// create sql to delete profesor
		String sql = "delete from Profesor where id=?";

		try (Connection myConn = dataSource.getConnection(); PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			int profesorId = theId;
			myStmt.setInt(1, profesorId);
			// execute sql statement
			myStmt.execute();

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
