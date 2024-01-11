
public class Student {
	
	String name;
	String major;
	int credits;
	Instructor advisor;
	int id;
	float gpa;
	
	
	/**
	 * Constructors
	 */
	public Student() {
		super();
	}
	
	public Student(String name, String major, int creds, Instructor advisor, int id, float gpa) {
		super();
		this.name = name;
		this.major = major;
		this.credits = creds;
		this.advisor = advisor;
		this.id = id;
		this.gpa = gpa;
		
	}
	
	public Student(int id) {
		this.id = id;
	}
	
	public Student (int id, String name, String major, int creds) {
		super();
		this.id = id;
		this.name = name;
		this.major = major;
		this.credits = creds;
	}
	
	public Student(String name, String major, int creds, Instructor advisor, int id) {
		super();
		this.name = name;
		this.major = major;
		this.credits = creds;
		this.advisor = advisor;
		this.id = id;
	}
	
	
	
	//-------------------------------------------------------GETTERS AND SETTERS------------------------------------------------------------
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public Instructor getAdvisor() {
		return advisor;
	}
	public void setAdvisor(Instructor advisor) {
		this.advisor = advisor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
