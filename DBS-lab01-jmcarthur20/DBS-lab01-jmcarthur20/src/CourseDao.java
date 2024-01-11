import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface CourseDao {
	
	/**
	 * method to get a course from the database with a specific ID
	 * @param id
	 * @return
	 */
	public static Course getCourse(int id) {

		Course tempCourse = null; 	// creating a temporary course that i will add the results to and later return
		try {

			Connection conn = null;
			try  {
				Class.forName("org.sqlite.JDBC");			// connecting to db
				String url = "jdbc:sqlite:uni2.db";
				conn = DriverManager.getConnection(url);

				PreparedStatement stmt = conn.prepareStatement("select * from course where course_id = ?"); 	// selecting the course using the id
				stmt.setInt(1, id); 	// set the id to what was inputed as a parameter
				ResultSet rs = stmt.executeQuery(); 	// execute

				while (rs.next()) {
					String name = rs.getString("title");
					System.out.println(name);
				}

				int tempId = rs.getInt("course_id"); 		// copy the values from the query 
				String tempName = rs.getString("title");
				int tempCreds = rs.getInt("credits");

				tempCourse = new Course(tempId, tempName, tempCreds); 		// add them to the temp course

				rs.close(); 		// close the query
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

		return tempCourse; 			// return the course
	}

	/**
	 * method to create a course and add it to the database
	 * @param course
	 */
	public static void createCourse (Course course) {

		try {

			Connection conn = null;
			try  {
				Class.forName("org.sqlite.JDBC"); 		// connect to db
				String url = "jdbc:sqlite:uni2.db";
				conn = DriverManager.getConnection(url);

				PreparedStatement stmt = conn.prepareStatement("insert into course (course_id, title, credits) values (?,?,?)"); // add into course the values put in the parameter
				stmt.setInt(1, course.getCourseId()); 	// setting the values from the param
				stmt.setString(2, course.getTitle());
				stmt.setInt(3, course.getCredits());

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
	}
	
	/**
	 * method to update a course in the database with new info
	 * @param c
	 */
	public static void updateCourse (Course c) {

		try {

			Connection conn = null;
			try  {
				Class.forName("org.sqlite.JDBC"); 		// connect to db
				String url = "jdbc:sqlite:uni2.db";
				conn = DriverManager.getConnection(url);

				PreparedStatement stmt = conn.prepareStatement("update course set title = ?, credits = ? where course_id = ?"); // update the specified course with this new info
				stmt.setString(1, c.getTitle()); 		// adding the param values
				stmt.setInt(2, c.getCredits());
				stmt.setInt(3, c.getCourseId());


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

		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * method to delete a course from the database
	 * @param c
	 */
	public static void deleteCourse (Course c) {
		
		try {
			
			Connection conn = null;
			try  {
			    Class.forName("org.sqlite.JDBC"); 		//connect to db
			    String url = "jdbc:sqlite:uni2.db";
			    conn = DriverManager.getConnection(url);
			    
			    PreparedStatement stmt = conn.prepareStatement("delete from course where course_id = ?"); // delete the proper course
			    stmt.setInt(1, c.getCourseId()); // given this ID
			 
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
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
