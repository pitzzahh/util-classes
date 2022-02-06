package lib.systems.studentManagementSystem.old;

final class Student extends List{
	
	private String firstName;  
	private String lastName; 
	private String gender; 
	private String learningModality; 
	private String classSection;
	private static byte numberOfStudents;
	
	public Student(String firstName, String lastName, String gender, String learningModality, String classSection) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.learningModality = learningModality;
		this.classSection = classSection;
		numberOfStudents++;
	
	}
	static String numberOfStudent() {
		return "Number of Students: "+ numberOfStudents;
	}

	// returns string values
	public String toString() {
		return "LastName: "+lastName+"\n"
				+"FirstName: "+firstName+"\n"
				+"Gender: "+gender+"\n"
				+"LearningModality: "+learningModality+"\n"
				+"ClassSection: "+classSection;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getGender() {
		return this.gender;
	}

	public String getLearningModality() {
		return this.learningModality;
	}

	public String getClassSection() {
		return this.classSection;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setLearningModality(String learningModality) {
		this.learningModality = learningModality;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}
}
