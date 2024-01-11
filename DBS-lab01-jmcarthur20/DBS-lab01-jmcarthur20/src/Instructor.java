
public class Instructor {
	
	private int id;
	String name;
	int salary;
	Student[] students;
	
	/**
	 * Constructors
	 */
	public Instructor() {
		super();
	}
	
	public Instructor(int id, String name, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.salary = sal;
	}

	/**
	 * method to add a student as an advisee under this instructor
	 * @param s
	 */
	public void addStudent(Student s) {
		
		students[students.length + 1] = s; // add the param student at the back of the list
	}
	
	
	
	//--------------------------------------------GETTERS AND SETTERS----------------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	
	
}
