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

	public List<Student> allStudents () { 		
		return StudentDao.allStudents();
	}

	public void createStudent(Student s) {

		StudentDao.CreateStudent(s);
	}

	public void updateStudent (Student s) {

		StudentDao.updateStudent(s);
	}

	public void deleteStudent (int id) {

		StudentDao.deleteStudent(id);
	}
	
	public double getGpa (Student s) {
		return StudentDao.getGpa(s);
	}
	
	public Instructor getInst (Student s) {
		return StudentDao.getInst(s);
	}

	/**
	 * Method to get the id's of all students in string form
	 * @param s
	 * @return
	 */
	public String[] allIds (List<Student> s) {
		String[] ids = new String[s.size()];
		
		for (int i = 0; i < s.size(); i++) {
			ids[i] = String.valueOf(s.get(i).getId());
		}
		
		return ids;
	}
	
	
	
}
