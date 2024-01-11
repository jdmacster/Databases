import javax.swing.JTable;

public class JdbcCourseDao implements CourseDao {
	
	/**
	 * Constructor
	 */
	public JdbcCourseDao() {
		super();
	}
	
	/**
	 * the rest of these methods all simply use their matching method in the CourseDao, these just run them
	 * @param id
	 * @return
	 */
	public Course getCourse(int id) {
		
		return CourseDao.getCourse(id);
	}
	
	
	public void createCourse(Course c) {
		
		CourseDao.createCourse(c);
	}
	
	public void updateCourse (Course c) {
		
		CourseDao.updateCourse(c);
	}
	
	public void deleteCourse (Course c) {
		
		CourseDao.deleteCourse(c);
	}
	
}
