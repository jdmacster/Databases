import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface InstructorDao {

	/**
	 * method to get an instructor from the database
	 * @param id
	 * @return
	 */
	public static Instructor getInst(int id) {

		Instructor tempInst = null; // creating a temp instructor to pass the data into and later return
		try {

			Connection conn = null;
			try  { 
				Class.forName("org.sqlite.JDBC"); 	// connect to db
				String url = "jdbc:sqlite:uni.db";
				conn = DriverManager.getConnection(url);

				PreparedStatement stmt = conn.prepareStatement("select * from instructor where ID = ?"); // select the instructor 
				stmt.setInt(1, id); // with this ID
				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {		// iterate through results
					String name = rs.getString("name");
					System.out.println(name);
				}

				int tempId = rs.getInt("ID"); 		// copy the data we get
				String tempName = rs.getString("name");
				int tempSal = rs.getInt("salary");

				tempInst = new Instructor(tempId, tempName, tempSal); // add it to the instructor

				rs.close(); // close the query
				stmt.close();

				System.out.println("Connection to SQLite has been established.");


			} catch (SQLException e) {
				System.out.println("error");
				System.out.println(e.getMessage());
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}



		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		return tempInst; 		// return our result
	}
	
	/**
	 * method to create an instructor and add it to the database
	 * @param i
	 */
	public static void createInst (Instructor i) {

		try {

			Connection conn = null;
			try  { 
				Class.forName("org.sqlite.JDBC"); 	// connect to db
				String url = "jdbc:sqlite:uni.db";
				conn = DriverManager.getConnection(url);

				PreparedStatement stmt = conn.prepareStatement("insert into instructor (ID, name, salary) values (?,?,?)"); // insert the instructor
				stmt.setInt(1, i.getId()); 		// with these values
				stmt.setString(2, i.getName());
				stmt.setInt(3, i.getSalary());

				stmt.close(); // and close the query

				System.out.println("Connection to SQLite has been established.");


			} catch (SQLException e) {
				System.out.println("error");
				System.out.println(e.getMessage());
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * method to update an instructor with the one passed as a param
	 * @param i
	 */
	public static void updateInst (Instructor i) {

		try {

			Connection conn = null;
			try  {
				Class.forName("org.sqlite.JDBC"); 		// connect to db
				String url = "jdbc:sqlite:uni.db";
				conn = DriverManager.getConnection(url);

				PreparedStatement stmt = conn.prepareStatement("update instructor set name = ?, salary = ? where ID = ?"); // update the instructor
				stmt.setString(1, i.getName()); // matching these values
				stmt.setInt(2, i.getSalary());
				stmt.setInt(3, i.getId());


				stmt.close(); // close the query

				System.out.println("Connection to SQLite has been established.");


			} catch (SQLException e) {
				System.out.println("error");
				System.out.println(e.getMessage());
			} finally {
				try {
					if (conn != null) {
						conn.close();
					}
				} catch (SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}

		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * method to delete an instructor from the database
	 * @param i
	 */
	public static void deleteInst (Instructor i) {
		
		try {
			
			Connection conn = null;
			try  {
			    Class.forName("org.sqlite.JDBC"); 		// connect to db
			    String url = "jdbc:sqlite:uni.db";
			    conn = DriverManager.getConnection(url);
			    
			    PreparedStatement stmt = conn.prepareStatement("delete from instructor where ID = ?"); // delete the instructor
			    stmt.setInt(1, i.getId()); // with this ID
			 
			    stmt.close(); // and close the query
			    
			    System.out.println("Connection to SQLite has been established.");
			    

			} catch (SQLException e) {
			    System.out.println("error");
			    System.out.println(e.getMessage());
			} finally {
			    try {
			        if (conn != null) {
			            conn.close();
			        }
			    } catch (SQLException ex) {
			        System.out.println(ex.getMessage());
			    }
			}
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
