
public class Transcript {
	
	int courseId;
	String semester;
	int year;
	double grade;
	
	Course[] trans;
	
	
	/**
	 * Constructors
	 */
	public Transcript() {
		super();
	}
	
	public Transcript(int cId, String sem, int year, double grade) {
		super();
		this.courseId = cId;
		this.semester = sem;
		this.year = year;
		this.grade = grade;
	}

	/**
	 * Method to get the grades from every course and add them to an average
	 * @param courses
	 * @return
	 */
	public double Gpa(Course[] courses) {
		double tempGpa = 0;
		
		for (int i = 0; i < courses.length; i++) {
			tempGpa += courses[i].getGrade();
		}
		
		return (tempGpa / courses.length);
	}
	
	
	
	
	
	
	//------------------------------------------------------------GETTERS AND SETTERS---------------------------------------

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

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Course[] getTrans() {
		return trans;
	}

	public void setTrans(Course[] trans) {
		this.trans = trans;
	}
	
	
}
