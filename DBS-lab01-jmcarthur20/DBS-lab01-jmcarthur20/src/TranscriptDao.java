import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TranscriptDao {
	
	/**
	 * method to get a transcript from the takes table given a particular student
	 * @param id
	 * @return
	 */
	public static Transcript getTrans(int id) {

		Transcript tempTrans = null; // create a temporary transcript to pass the data we get 
		try {

			Connection conn = null;
			try  {
				Class.forName("org.sqlite.JDBC"); 		// connect to the db
				String url = "jdbc:sqlite:uni2.db";
				conn = DriverManager.getConnection(url);

				PreparedStatement stmt = conn.prepareStatement("select * from takes where ID = ?"); // select the courses
				stmt.setInt(1, id); // that the student with this ID has taken
				ResultSet rs = stmt.executeQuery();

				int i = 0; // temporary variable to keep track of the number of iterations
				while (rs.next()) { // iterate through the results and add each row as a course in the transcript course array
					String name = rs.getString("ID");
					System.out.println(name);
					
					Course c = new Course(rs.getInt("course_id"), rs.getString("title"), rs.getInt("credits")); // add the values from each row into a course object
					
					tempTrans.trans[i] = c; // add the course object to the array
							
					i++; // increase the iteration so that each course will have a place in the array
				}

				rs.close(); 	// close the query
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

		return tempTrans;
	}
}
