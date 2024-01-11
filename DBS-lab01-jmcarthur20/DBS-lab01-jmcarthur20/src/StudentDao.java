import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

public interface StudentDao {
	
	/**
	 * method to get and return a student from the database
	 * @param id
	 * @return
	 */
	public static Student getStudent(int id) {
		
		Student tempStud = null; // creating a temporary student to pass the values we get into and later return
		try {
			
			Connection conn = null;
			try  {
			    Class.forName("org.sqlite.JDBC"); 		// connect to db
			    String url = "jdbc:sqlite:uni2.db";
			    conn = DriverManager.getConnection(url);
			    
			    PreparedStatement stmt = conn.prepareStatement("select * from student where ID = ?"); // select the student
			    stmt.setInt(1, id); // with this ID
			    
			    ResultSet rs = stmt.executeQuery(); 
			    
			    while (rs.next()) { 	// iterate through the results in the db
			        String name = rs.getString("name");
			        System.out.println(name);
			    }
			    
			    int tempId = rs.getInt("ID"); 					// copy the info from that student
			    String tempName = rs.getString("name");
			    String tempMajor = rs.getString("dept_name");
			    int tempCreds = rs.getInt("tot_cred");
			    
			    tempStud = new Student(tempName, tempMajor, tempCreds, tempStud.getAdvisor(), tempId); // add it to the temp student
			    
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
		
		return tempStud; // and return the student
		
	}
	
	
	public static List<Student> allStudents () {

		List<Student> tempStuds = new ArrayList<>(); // creating a temporary list of students to pass the values we get into and later return
		try {
			
			Connection conn = null;
			try  {
			    Class.forName("org.sqlite.JDBC"); 		// connect to db
			    String url = "jdbc:sqlite:uni2.db";
			    conn = DriverManager.getConnection(url);
			    
			    PreparedStatement stmt = conn.prepareStatement("select * from student"); // select the students
			    
			    ResultSet rs = stmt.executeQuery(); 
			    
			    while (rs.next()) { 	// iterate through the results in the db
			        
			        int tempId = rs.getInt("ID"); 					// copy the info from that student
				    String tempName = rs.getString("name");
				    String tempMajor = rs.getString("dept_name");
				    int tempCreds = rs.getInt("tot_cred");
			        
			        Student stud = new Student( tempId, tempName, tempMajor, tempCreds); // add it to the temp student
			        tempStuds.add(stud); // add the temp student to the list
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

		return tempStuds; // and return the list of students 
		
	}
	
	/**
	 * method to create a student and add it to the database
	 * @param stud
	 */
	public static void CreateStudent (Student stud) {
		
		try {
			
			Connection conn = null;
			try  {
			    Class.forName("org.sqlite.JDBC"); 		// connect to db
			    String url = "jdbc:sqlite:uni2.db";
			    conn = DriverManager.getConnection(url);
			    
			    PreparedStatement stmt = conn.prepareStatement("insert into student (ID, name, dept_name, tot_cred) values (?,?,?,?)"); // insert a new student 
			    stmt.setInt(1, stud.getId()); 		// with these values
			    stmt.setString(2, stud.getName());
			    stmt.setString(3, stud.getMajor());
			    stmt.setInt(4, stud.getCredits());
			    
			    stud.setAdvisor(stud.advisor); // update the advisor
			 
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
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * method to update a student's info with the student passed in the param
	 * @param stud
	 */
	public static void updateStudent (Student stud) {
		
		try {
			
			Connection conn = null;
			try  {
			    Class.forName("org.sqlite.JDBC"); 		// connect to db
			    String url = "jdbc:sqlite:uni2.db";
			    conn = DriverManager.getConnection(url);
			    
			    PreparedStatement stmt = conn.prepareStatement("update student set name = ?, dept_name = ?, tot_cred = ? where ID = ?"); // update the student
			    stmt.setString(1, stud.getName()); 	// with these values
			    stmt.setString(2, stud.getMajor());
			    stmt.setInt(3, stud.getCredits());
			    stmt.setInt(4, stud.getId());
			    
			    stud.setAdvisor(stud.advisor); // update the advisor
			 
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
	 * method to delete a student from the database
	 * @param stud
	 */
	public static void deleteStudent (Student stud) {
		
		try {
			
			Connection conn = null;
			try  {
			    Class.forName("org.sqlite.JDBC"); 		// connect to the db
			    String url = "jdbc:sqlite:uni2.db";
			    conn = DriverManager.getConnection(url);
			    
			    PreparedStatement stmt = conn.prepareStatement("delete from student where ID = ?"); // delete the student
			    stmt.setInt(1, stud.getId()); // with this ID
			 
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
	
