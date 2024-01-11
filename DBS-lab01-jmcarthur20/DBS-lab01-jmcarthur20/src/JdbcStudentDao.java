import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JdbcStudentDao implements StudentDao {
	
	/**
	 * Constructor
	 */
	public JdbcStudentDao() {
		super();
	}
	
	/**
	 * the rest of these methods all simply use their matching method in the StudentDao, these just run them
	 * @param id
	 * @return
	 */
	public Student getStudent(int id) {
		
		return StudentDao.getStudent(id);
	}
	
	public Object[] allStudents () { 		// this was an attempt at converting my List of students into an array so that I could put it into the
											// JTable in the GUI, but it didn't work and I ran out of time
		return StudentDao.allStudents().toArray();
			
		}
	
	public void createStudent(Student s) {
		
		StudentDao.CreateStudent(s);
	}
	
	public void updateStudent (Student s) {
		
		StudentDao.updateStudent(s);
	}
	
	public void deleteStudent (Student s) {
		
		StudentDao.deleteStudent(s);
	}
	
	

}
