package lib.systems.studentManagementSystem.old;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CallingStudents extends List {

	public static void run(String[] args) {

		System.out.print(Student.numberOfStudent());
		System.out.println();
        int choice;
        
        Scanner keyboardInput = new Scanner(System.in);
        System.out.print("Input student number: ");
              
        choice = keyboardInput.nextInt();
        
        try { 
        	System.out.println();
			switch (choice) {
				case 1 -> System.out.println(Student.student1.toString());
				case 2 -> System.out.println(Student.student2.toString());
				case 3 -> System.out.println(Student.student3.toString());
				case 4 -> System.out.println(Student.student4.toString());
				case 5 -> System.out.println(Student.student5.toString());
				case 6 -> System.out.println(Student.student6.toString());
				case 7 -> System.out.println(Student.student7.toString());
				case 8 -> System.out.println(Student.student8.toString());
				case 9 -> System.out.println(Student.student9.toString());
				case 10 -> System.out.println(Student.student10.toString());
				case 11 -> System.out.println(Student.student11.toString());
				case 12 -> System.out.println(Student.student12.toString());
				default -> System.out.println("only from 1 to the maximum number of students");
			} // end of switch statement
			keyboardInput.close();
        } // end of try statement
        catch (InputMismatchException ignored) {
        }
		System.out.println();
	}
}

		