package lib.systems.studentManagementSystem.processes.sorting;

import lib.systems.studentManagementSystem.studentConstruct.Student;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author Peter John Arao
 * @version 2.0
 */
public final class SortProcessing {

    /**
     * Private constructor, this prevents any packages from using this class
     */
    private SortProcessing() {
    }
    /**  
     * Method that sorts students ID in Ascending order
     * @param studentList that takes the studentList array
     */
    public static void sortIdAscending(final ArrayList<Student> studentList) {
        studentList.sort(Comparator.comparing(Student::getId));
    }
    /**
     * Method that sorts students ID in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortIdDescending(final ArrayList<Student> studentList) {
        studentList.sort((object1, object2) -> object2.getId().compareTo(object1.getId()));
    }
    /** 
     * Method that sorts students LastName in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortLastNameAscending(final ArrayList<Student> studentList) {
	    studentList.sort(Comparator.comparing(Student::getLastName));
    }
    /** 
     * Method that sorts students LastName in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortLastNameDescending(final ArrayList<Student> studentList) {
	    studentList.sort((object1, object2) -> object2.getLastName().compareTo(object1.getLastName()));
    }	
    /** 
     * Method that sorts students FirstName in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortFirstNameAscending(final ArrayList<Student> studentList) {
	    studentList.sort(Comparator.comparing(Student::getFirstName));
    }
    /** 
     * Method that sorts student FirstName in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortFirstNameDescending(final ArrayList<Student> studentList) {
	    studentList.sort((object1, object2) -> object2.getFirstName().compareTo(object1.getFirstName()));
    }
    /** 
     * Method that sorts students Age in Ascending order
     * @param studentList that takes the studentList array
     */
    public static void sortAgeAscending(final ArrayList<Student> studentList) {
        studentList.sort(Comparator.comparingInt(Student::getAge));
    }
    /** 
     * Method that sorts students Age in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortAgeDescending(final ArrayList<Student> studentList) {
        studentList.sort((object1, object2) -> Byte.compare(object2.getAge(), object1.getAge()));
    }
    /** 
     * Method that sorts students Gender in Ascending order
     * @param studentList that takes the studentList array
     */
    public static void sortGenderAscending(final ArrayList<Student> studentList) {
	    studentList.sort(Comparator.comparing(Student::getGender));
    }
    /** 
     * Method that sorts student Gender in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortGenderDescending(final ArrayList<Student> studentList) {
	    studentList.sort((object1, object2) -> object2.getGender().compareTo(object1.getGender()));
    }
    /** 
     * Method that sorts students SchoolName in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortSchoolNameAscending(final ArrayList<Student> studentList) {
        studentList.sort(Comparator.comparing(Student::getSchool));
    }
    /** 
     * Method that sorts student SchoolName in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortSchoolNameDescending(final ArrayList<Student> studentList) {
	    studentList.sort((object1, object2) -> object2.getSchool().compareTo(object1.getSchool()));
    }
    /** 
     * Method that sorts students CourseName in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortCourseNameAscending(final ArrayList<Student> studentList) {
	    studentList.sort(Comparator.comparing(Student::getCourse));
    }
    /** 
     * Method that sorts student CourseName in Descending order
     * @param studentList that takes the studentList array
     */
    public static void sortCourseNameDescending(final ArrayList<Student> studentList) {
        studentList.sort((object1, object2) -> object2.getCourse().compareTo(object1.getCourse()));
    }
}
