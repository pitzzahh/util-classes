package lib.systems.studentManagementSystem.latest.studentConstruct;

public final class Student {

    private String id;
    private String firstName;  
    private String lastName; 
    private byte age;
    private String gender;
    private String school; 
    private String course;

    public String getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public byte getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    public String getSchool() {
        return this.school;
    }

    public String getCourse() {
        return this.course;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    /**
     * Method used in showing the list of students in the ArrayList studentsList.
     * Also used when exporting the list into a txt file
     * default value: exportChoiceLoop = true
     * @return a string representation of the students in the ArrayList studentsList
     */
    @Override
    public String toString() {
        return ":---------------------------------------------:" +
                "\n" +
                "     Student ID   : " +  id +
                "\n" +
                "     FirstName    : " + firstName +
                "\n" +
                "     LastName     : " + lastName +
                "\n" +
                "     Age          : " + age +
                "\n" +
                "     Gender       : " + gender +
                "\n" +
                "     School       : " + school +
                "\n" +
                "     Course       : " + course +
                "\n" +
                ":---------------------------------------------:";
	}
}
