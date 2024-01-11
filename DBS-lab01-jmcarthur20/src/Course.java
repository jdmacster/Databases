
public class Course {
	
	
	private int courseId;
	String title;
	int credits;
	int studId;
	String semester;
	int year;
	double grade;
	
	
	/**
	 * constructors
	 */
	public Course() {
		super();
	}
	
	public Course(int cId, String title, int creds) {
		super();
		this.courseId = cId;
		this.title = title;
		this.credits = creds;
	}
	
	public Course(int cId, String title, int creds, int sId, String sem, int year, double grade) {
		super();
		this.courseId = cId;
		this.title = title;
		this.credits = creds;
		this.studId = sId;
		this.semester = sem;
		this.year = year;
		this.grade = grade;
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

	public int getStudId() {
		return studId;
	}

	public void setStudId(int studId) {
		this.studId = studId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}
	
	
}
