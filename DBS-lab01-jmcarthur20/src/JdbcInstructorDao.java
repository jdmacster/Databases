
public class JdbcInstructorDao implements InstructorDao {
	
	/**
	 * Constructor
	 */
	public JdbcInstructorDao() {
		super();
	}
	
	/**
	 * the rest of these methods all simply use their matching method in the InstructorDao, these just run them
	 * @param id
	 * @return
	 */
	public Instructor getInst(int id) {
		
		return InstructorDao.getInst(id);
	}
	
	
	public void createInst (Instructor i) {
		
		InstructorDao.createInst(i);
	}
	
	public void updateInst (Instructor i) {
		
		InstructorDao.updateInst(i);
	}
	
	public void deleteInst (Instructor i) {
		
		InstructorDao.deleteInst(i);
	}
	

}
