
public class Course {
	
	
	private int courseId;
	String title;
	int credits;
	
	
	/**
	 * constructors
	 */
	public Course() {
		super();
	}
	
	public Course(int id, String title, int creds) {
		super();
		this.courseId = id;
		this.title = title;
		this.credits = creds;
	}
	
	
	//-------------------------------------------GETTERS AND SETTERS-------------------------------------------------------
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	
}
