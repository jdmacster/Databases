
public class Transcript extends Student {
	
	int courseId;
	String semester;
	int year;
	float grade;
	
	Course[] trans;
	
	
	/**
	 * Constructors
	 */
	public Transcript() {
		super();
	}
	
	public Transcript(int cId, String sem, int year, float grade) {
		super();
		this.courseId = cId;
		this.semester = sem;
		this.year = year;
		this.grade = grade;
	}

	
	
	
	
	
	
	//------------------------------------------------------------GETTERS AND SETTERS---------------------------------------
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public Course[] getTrans() {
		return trans;
	}

	public void setTrans(Course[] trans) {
		this.trans = trans;
	}
	
	
}
