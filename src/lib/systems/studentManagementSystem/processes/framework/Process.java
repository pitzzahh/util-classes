package lib.systems.studentManagementSystem.processes.framework;

import lib.systems.studentManagementSystem.processes.sorting.SortProcessing;
import lib.systems.studentManagementSystem.studentConstruct.Student;
import lib.systems.studentManagementSystem.constants.Constants;
import lib.systems.studentManagementSystem.main.MainActivity;
import lib.utilities.misc.InputChecker;
import lib.utilities.misc.Decorations;
import lib.utilities.misc.Delay;
import lib.utilities.FileUtil;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;

public class Process {

	// field used to store the user sorting choice, default value: sortingChoice = 0
	protected static byte sortingChoice = 0;

	// field used in importList method, default value: importing = true
	protected static boolean importing = true;

	// field used in storing the path used in importing, default value: importPath = ""
	protected static String importPath = "";

	// field used in storing the file name used in importing, default value: importFileName = ""
	protected static String importFileName = "";

	/**
	 * Field used to check if the user input matches this field.
	 * <p> default value: {@code YES}
	 */
	protected static final String FIRST_RESPONSE = "YES";

	/**
	 * Field used to check if the user input matches this field.
	 * <p> default value: {@code NO}
	 */
	protected static final String SECOND_RESPONSE = "NO";

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> Process class, {@code importList} method, {@code resetMain} method.
	 * <p> Stores the user choice in {@code importList}  method.
	 * <p> default value: {@code importErrorResponse = u0000}
	 */
	protected static char importErrorResponse;

	/**
	 * Field used in {@code exportList} method.
	 * <p> default value:{@code exporting = true}
	 */
	protected static boolean exporting = true;

	/**
	 * Field used in storing the path used in {@code exporting} method.
	 * <p> default value:{@code exportPath = ""}
	 */
	protected static String exportPath = "";

	/**
	 * Field used in storing the file name used in {@code exporting} method.
	 * <p> default value:{@code exportFileName = ""}
	 */
	protected static String exportFileName = "";

	/**
	 * Field used in {@code MainActivity} class, {@code main} method. {@code Process} class, {@code exportList} method, {@code resetMain} method.
	 * <p> Stores the user choice in {@code exportList} method.
	 * <p> default value:{@code exportErrorResponse = u0000}
	 */
	protected static char exportErrorResponse;

	/**
	 * Field used in {@code Process} class, {@code createStudent} method. Also used in adding a {@code studentId} loop condition
	 * <p> default value:{@code addStudentId = true}
	 */
	protected static boolean addStudentId = true;

	/**
	 * Field used in {@code Process} class, {@code createStudent} method. Also used in adding a {@code firstName} loop condition
	 * <p> default value: {@code addFirstName = true}
	 */
	protected static boolean addFirstName = true;

	/**
	 * Field used in {@code Process} class, {@code createStudent} method. Also used in adding a {@code lastName} loop condition
	 * <p> default value: {@code addLastName = true}
	 */
	protected static boolean addLastName = true;

	/**
	 * Field used in {@code Process} class, {@code createStudent} method. Also used in adding a {@code age} loop condition
	 * <p> default value: {@code addLastName = true}
	 */
	protected static boolean addAge = true;

	/**
	 * Field used in {@code Process} class, {@code createStudent} method. Also used in adding a {@code gender} loop condition
	 * <p> default value: {@code addGender = true}
	 */
	protected static boolean addGender = true;

	/**
	 * Field used in {@code Process} class, {@code createStudent} method. Also used in adding a {@code school} loop condition
	 * <p> default value: {@code addSchool = true}
	 */
	protected static boolean addSchool = true;

	/**
	 * Field used in {@code Process} class, {@code createStudent} method. Also used in adding a {@code course} loop condition
	 * <p> default value: {@code addCourse = true}
	 */
	protected static boolean addCourse = true;

	/**
	 * Field used in {@code Process} class, {@code sortStudentList} method.
	 * <p> default value: {@code emptySortingLoopChoice = false}
	 */
	protected static boolean emptySortingLoopChoice = false;

	/**
	 * Field used in {@code Process} class, {@code removeInTheList} method.
	 * <p> default value: {@code removeLrn = false}
	 */
	protected static boolean removeLrn;

	/**
	 * Field used in {@code Process} class, {@code sortStudentList} method.
	 * <p> default value: {@code sorting = true}
	 */
	protected static boolean sorting = true;

	/**
	 * Field used in {@code Process} class, {@code sortStudentList} method.
	 * <p> default value: {@code nextStep = true}
	 */
	protected static boolean nextStep = true;

	/**
	 * Field used in {@code Process} class, {@code sortStudentList} method.
	 * <p> default value: {@code empty = true}
	 */
	protected static boolean empty = true;

	/**
	 * Field used in {@code Process} class, {@code createStudent} method.
	 * <p> default value: {@code lrnResponse = ""}
	 */
	protected static String lrnResponse = "";

	/**
	 * Field used in {@code Process} class, {@code createStudent} method and {@code addList} method
	 * <p> default value: {@code invalidId = false}
	 */
	protected static boolean invalidId = false;

	/**
	 * Field used in {@code Process} class, {@code removeInTheList} method.
	 * <p> default value: {@code invalidIdDeletion = false}
	 */
	protected static boolean invalidIdDeletion;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> {@code boolean} field used when checking if the main menu choice is valid or not
	 * <p> default value: {@code isValidMainChoice = false}
	 * @see MainActivity#run() run()
	 * @see Process#resetMain() resetMain()
	 */
	protected static boolean isValidMainChoice = false;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> {@code boolean} field used in looping through the choice of the user in the main menu choices
	 * <p> default value: {@code choiceCheck = true}
	 * @see Process#resetMain() resetMain()
	 */
	protected static boolean choiceCheck = true;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> {@code boolean} field used in looping the whole program
	 * <p> default value: {@code choiceCheck = true}
	 * @see Process#importList(String) importList()
	 * @see Process#resetMain() resetMain()
	 */
	protected static boolean isNotExit = true;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> {@code boolean} field used in looping when exporting.
	 * <p> default value: {@code exportFileTypeChoice = 0}
	 * @see MainActivity#run() run()
	 * @see Process#exportList(String) exportList()
	 * @see Process#resetMain() resetMain()
	 */
	protected static byte exportFileTypeChoice;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> {@code boolean} field used in looping when importing.
	 * <p> default value: {@code importChoiceLoop = true}
	 * @see MainActivity#run() run()
	 * @see Process#importList(String) importList()
	 * @see Process#resetMain() resetMain()
	 */
	protected static boolean importChoiceLoop = true;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> {@code boolean} field used in looping when exporting.
	 * <p> default value: {@code exportChoiceLoop = true}
	 * @see MainActivity#run() run()
	 * @see Process#exportList(String) exportList()
	 * @see Process#resetMain() resetMain()
	 */
	protected static boolean exportChoiceLoop = true;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> {@code boolean} field used in looping when importing.
	 * <p> default value: {@code importFileTypeChoice = 0}
	 * @see MainActivity#run() run()
	 * @see Process#importList(String) importList()
	 * @see Process#resetMain() resetMain()
	 */
	protected static byte importFileTypeChoice;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> Stores the user choice from the main menu choices
	 * <p> default value: {@code mainChoice = 0}
	 * @see MainActivity#run() run()
	 * @see Process#resetMain() resetMain()
	 */
	protected static byte mainChoice;

	// Identifier for the Scanner object
	protected static Scanner userInput;

	/**
	 * Field used in {@code MainActivity} class, {@code main} method.
	 * <p> Storing student list into an {@code ArrayList} studentsList, the data type is the {@code Student} class.
	 * <p> Stores the user choice from the main menu choices
	 * <p> {@code Array size: 200}
	 * <p> Can be found in the following methods: {@link Process#exportList(String) exportList()}, {@link Process#showList() showList()},
	 * {@link Process#removeInTheList() removeInTheList()}, {@link Process#sortStudentList() sortStudentList()},
	 * {@link Process#isEmptyList() isEmptyList()}, {@link Process#isNotEmptyList() isNotEmptyList()}, {@link Process#clearList() clearList()},
	 * {@link Process#numberOfStudent() numberOfStudent()}, {@link Process#isIdExisted(String) isIdExisted()}, and {@link Process#addList() addList()},
	 */
	protected static ArrayList<Student> studentsList = new ArrayList<>(200);

	/**
	 * Private constructor, this prevents any packages from instantiating this class
	 */
	protected Process() {
	}

	/**
	 * Method that creates the student information then returning it.
	 * <p>
	 * @return {@code Student} object to be added in the array {@code studentsList}.
	 * Else returns {@code null} if the user did not proceed in the middle of execution of this method
	 * @see Process#addList() addList()
	 */
	protected static Student createStudent() throws InterruptedException {

		Student student = new Student();
		String temporaryString;

		while (addStudentId) {
			System.out.println(":-----------------------------:");
			System.out.println(":         Student ID          : ");
			System.out.println(":-----------------------------:");
			System.out.print("   >>>>: ");

			temporaryString = userInput.nextLine().trim();

			if (temporaryString.matches("[0-9]+") && ( temporaryString.length() == 10 || temporaryString.length() == 11 || temporaryString.length() == 12) ) {
				if (isIdExisted(temporaryString)) {
					System.out.println(":THIS ID IS ALREADY EXISTED(!):");
					tryAgain();
				}
				else {
					resetConditions();
					student.setId(temporaryString);
					addStudentId = false;
				}
			}
			else {
				System.out.println("\n : STUDENT ID MUST BE 10 or 11 or 12 NUMBERS (!) :");
				System.out.println("          : PLEASE TRY AGAIN :           ");
				tryAgain();
			}
		}
		// FirstName
		while (addFirstName) {
			System.out.println(":-----------------------------:");
			System.out.println(":     Student FirstName       : ");
			System.out.println(":-----------------------------:");
			System.out.print("   >>>>: ");

			temporaryString = userInput.nextLine().trim();

			if (temporaryString.length() != 0) {
				if (InputChecker.isInteger(temporaryString)) {
					System.out.println();
					Decorations.line();
					System.out.println("        : A FIRST NAME IS NOT A NUMBER :       ");
					Decorations.line();
				}
				else if(temporaryString.matches("[!@#$%^&*()]+")) {
					Decorations.line();
					System.out.println("   : PLEASE ENTER YOUR FIRST NAME PROPERLY :   ");
					Decorations.line();
				}
				else {
					student.setFirstName(temporaryString);
					addFirstName = false;
				}
			}
			else {
				Decorations.line();
				System.out.println("        : PLEASE DO NOT LEAVE IT BLANK (!) :   ");
				Decorations.line();
			}
		}
		// LastName
		while (addLastName) {
			System.out.println(":-----------------------------:");
			System.out.println(":      Student LastName       : ");
			System.out.println(":-----------------------------:");
			System.out.print("   >>>>: ");

			temporaryString = userInput.nextLine().trim();

			if (temporaryString.length() != 0) {
				if (InputChecker.isInteger(temporaryString)) {
					System.out.println();
					Decorations.line();
					System.out.println("        : A LAST NAME IS NOT A NUMBER :        ");
					Decorations.line();
				}
				else if(temporaryString.matches("[!@#$%^&*()]+")) {
					Decorations.line();
					System.out.println("   : PLEASE ENTER YOUR LAST NAME PROPERLY :    ");
					Decorations.line();
				}
				else {
					student.setLastName(temporaryString);
					addLastName = false;
				}
			}
			else {
				Decorations.line();
				System.out.println("        : PLEASE DO NOT LEAVE IT BLANK (!) :   ");
				Decorations.line();
			}
		}
		// Age
		while (addAge) {
			try {
				System.out.println(":-----------------------------:");
				System.out.println(":         Student Age         : ");
				System.out.println(":-----------------------------:");
				System.out.print("   >>>>: ");

				temporaryString = userInput.nextLine().trim();
				
				if (InputChecker.isByte(temporaryString)) {
					if (temporaryString.length() != 0) {
						byte age = Byte.parseByte(temporaryString); // 19
						if (age > 0) {
							student.setAge(age);
							addAge = false;
						}
						else {
							Decorations.line();
							System.out.println("       : A STUDENT AGE IS NOT BELOW ZERO :     ");
							Decorations.line();
						}
					}
				}
				else if (InputChecker.isInteger(temporaryString)) {
					Decorations.line();
					System.out.println("        : A STUDENT CANNOT BE THAT OLD :       ");
					Decorations.line();
				}
				else if (!InputChecker.isByte(temporaryString)) {
					Decorations.line();
					System.out.println("             : AN AGE IS A NUMBER :            ");
					Decorations.line();
				}
				else {
					Decorations.line();
					System.out.println("        : PLEASE DO NOT LEAVE IT BLANK (!) :   ");
					Decorations.line();
				}
			}
			catch (NumberFormatException n_f_e) {
				Decorations.line();
				System.out.println("             : AN AGE IS A NUMBER :            ");
				Decorations.line();
			}
			// here
		}
		// Gender
		while (addGender) {
			System.out.println(":-----------------------------:");
			System.out.println(":       Student Gender        : ");
			System.out.println(":-----------------------------:");
			System.out.print("   >>>>: ");

			temporaryString = userInput.nextLine().trim().toUpperCase();

			if (temporaryString.length() != 0) {
				if (InputChecker.isInteger(temporaryString)) {
					System.out.println();
					Decorations.line();
					System.out.println("          : A GENDER IS NOT A NUMBER :         ");
					Decorations.line();
				}
				else if(temporaryString.matches("[!@#$%^&*()]+") || temporaryString.length() <= 3) {
					Decorations.line();
					System.out.println("     : PLEASE ENTER YOUR GENDER PROPERLY :     ");
					Decorations.line();
				}
				else {
					student.setGender(temporaryString);
					addGender = false;
				}
			}
			else {
				Decorations.line();
				System.out.println("        : PLEASE DO NOT LEAVE IT BLANK (!) :   ");
				Decorations.line();
			}
		}
		// School
		while (addSchool) {
			System.out.println(":-----------------------------:");
			System.out.println(":       Student School        : ");
			System.out.println(":-----------------------------:");
			System.out.print("   >>>>: ");

			temporaryString = userInput.nextLine().trim().toUpperCase();

			if (temporaryString.length() != 0) {
				if (InputChecker.isInteger(temporaryString)) {
					System.out.println();
					Decorations.line();
					System.out.println("   : PLEASE ENTER YOUR SCHOOL NAME PROPERLY :  ");
					Decorations.line();
				}
				else if(temporaryString.matches("[!@#$%^&*()]+")) {
					Decorations.line();
					System.out.println("   : PLEASE ENTER YOUR SCHOOL NAME PROPERLY :  ");
					Decorations.line();
				}
				else {
					student.setSchool(temporaryString);
					addSchool = false;
				}
			}
			else {
				Decorations.line();
				System.out.println("        : PLEASE DO NOT LEAVE IT BLANK (!) :   ");
				Decorations.line();
			}
		}
		// Course
		while (addCourse) {
			System.out.println(":-----------------------------:");
			System.out.println(":       Student Course        : ");
			System.out.println(":-----------------------------:");
			System.out.print("   >>>>: ");

			temporaryString = userInput.nextLine().trim().toUpperCase();

			if (temporaryString.length() != 0) {
				if (InputChecker.isInteger(temporaryString)) {
					System.out.println();
					Decorations.line();
					System.out.println("  : PLEASE ENTER YOUR COURSE NAME PROPERLY :   ");
					Decorations.line();
				}
				else if(temporaryString.matches("[!@#$%^&*()]+")) {
					Decorations.line();
					System.out.println("  : PLEASE ENTER YOUR COURSE NAME PROPERLY :   ");
					Decorations.line();
				}
				else {
					student.setCourse(temporaryString);
					addCourse = false;
					invalidId = false;
				}
			}
			else {
				Decorations.line();
				System.out.println("        : PLEASE DO NOT LEAVE IT BLANK (!) :   ");
				Decorations.line();
			}
		}

		if(lrnResponse.equals("YES") && !invalidId) {
			System.out.print("                  : ADDING :");
			Delay.dotLoading("long");
		}
		else if (lrnResponse.equals("NO")) {
			System.out.print(' ');
		}
		else {
			if(invalidId) {
				System.out.print(' ');
			}
			else {
				System.out.print("                  : ADDING :");
				Delay.dotLoading("long");
			}
		}
		return student;
	}	// end of createStudent() method
	/**
	 * Method that is used when the user inputted wrong student ID, it prompts the user if the user wants to proceed or exit.
	 * @throws InterruptedException if the thread is interrupted
	 */
	protected static void tryAgain() throws InterruptedException {
		System.out.println("Do you want to try again?");
		System.out.println("YES or NO");
		System.out.print("   >>>>: ");
		lrnResponse = userInput.nextLine().toUpperCase().trim();
		if (lrnResponse.equals("YES")) {
			System.out.print("\t\t : PROCEEDING :");
			Delay.dotLoading("short");
		}
		else if (lrnResponse.equals("NO")) {
			System.out.print(": REDIRECTING TO MAIN MENU :");
			Delay.dotLoading("short");
			negateCreateStudentFunction();
			removeLrn = false;
		}
		else {
			Decorations.line();
			System.out.println("              : INVALID INPUT (!) :            ");
			Decorations.line();
			negateCreateStudentFunction();
			invalidId = true;
		}
	}

	/** 
	 * Method that Exports the list of Student, asks for the directory to be saved and its file name.
	 * <p>If studentList.size() == 0, the method exits and returns to main menu
	 * @param fileType (the type of file to be exported : .bin and .txt file is exported)
	 * @throws InterruptedException if the thread is interrupted
	 */
	protected static void exportList(final String fileType) throws InterruptedException {
		File directory;
		File fileName = null;
		if (studentsList.size() != 0) {
			while (exporting) {
				System.out.println(":-----------------------------:");
				System.out.println(":     ENTER THE FILE PATH     : ");
				System.out.println(":-----------------------------:");
				System.out.print("   >>>>: ");

				exportPath = userInput.nextLine().trim();
				directory = new File(exportPath);
				if (directory.isDirectory()) {
					System.out.println(":-----------------------------:");
					System.out.println(":     ENTER THE FILE NAME     : ");
					System.out.println(":-----------------------------:");
					System.out.print("   >>>>: ");
					exportFileName = userInput.nextLine().trim();
					fileName = new File(exportFileName);
					// file check
					if (!fileName.exists()) {
						exporting = false;
					}
					else {
						System.out.println("FILE ALREADY EXISTS!");
						System.out.println("PLEASE TRY OTHER FILE NAME!");
						System.out.println();
						System.out.println("Do you want to try again?");
						System.out.println("Y for yes : N for no");
						System.out.print("   >>>>: ");
						exportErrorResponse = userInput.nextLine().toUpperCase().charAt(0);
						if (exportErrorResponse == ('Y')) {
							System.out.print("\t\t : PROCEEDING :");
							Delay.dotLoading("short");
						}
						else if (exportErrorResponse == 'N') {
							exporting = false;
						}
						else {
							System.out.print(": REDIRECTING TO MAIN MENU :");
							Delay.dotLoading("short");
							exporting = false;
						}
					}
				}
				else {
					resetExportInputs();
					resetConditions();
					System.out.println("\n\t    INVALID FILE PATH (!)");
					System.out.println("Do you want to try again?");
					System.out.println("Y for yes : N for no");
					System.out.print("   >>>>: ");

					exportErrorResponse = userInput.nextLine().toUpperCase().charAt(0);
					if (exportErrorResponse == ('Y')) {
						resetExportInputs();
						resetConditions();
						System.out.print("\t\t : PROCEEDING :");
						Delay.dotLoading("short");
					}
					else if (exportErrorResponse == 'N') {
						System.out.print(": REDIRECTING TO MAIN MENU :");
						Delay.dotLoading("short");
						exporting = false;
					}
					else {
						System.out.print(": REDIRECTING TO MAIN MENU :");
						Delay.dotLoading("short");
						exporting = false;
					}
				}
			}
			// checks and solve
			try {

				if (fileName != null) {
					if (!fileName.exists()) {
						if(fileType.equals("text") || fileType.equals("bin")) {
							FileUtil.writeFileBinary(studentsList, exportPath + exportFileName);
							FileUtil.writeFile(studentsList, exportPath + exportFileName);
							System.out.print("                   : SAVING :");
							Delay.dotLoading("long");
							System.out.println("            : SAVED SUCCESSFULLY (!) :        ");
						}
					}
					else {
						System.out.println("ERROR");
					}
				}
			}
			catch (NullPointerException ignored) {
				System.out.println("     : INVALID CHOICE (!) :    ");
			}
			resetExportInputs();
		}
		else {
			System.out.println("            : THE LIST IS EMPTY (!) :       ");
			System.out.println("     : NO PRESENT DATA TO BE EXPORTED (!) :    ");
		}
	}

	/**
	 * Importing removes the current list. Imports the list of students from the local storage.
	 * <p> Checks if the directory and file is valid, if the directory or {@code file} is not valid,
	 * it asks the user if it wants to try again or proceed to main menu choices
	 * @param fileType (the type of file to be exported : .bin file is only exported)
	 * @throws InterruptedException importList
	 */
	protected static void importList(final String fileType) throws InterruptedException {

		File directory;
		File file = null;
		while (importing) {

			resetImportInputs();
			resetConditions();
			System.out.println(":-----------------------------:");
			System.out.println(":     ENTER THE FILE PATH     : ");
			System.out.println(":-----------------------------:");
			System.out.print("   >>>>: ");

			importPath = userInput.nextLine().trim();
			directory = new File(importPath);
			// directory check
			if (directory.isDirectory()) {
				System.out.println(":-----------------------------:");
				System.out.println(":     ENTER THE FILE NAME     : ");
				System.out.println(":-----------------------------:");
				System.out.print("   >>>>: ");
				importFileName = userInput.nextLine().trim();
				file = new File(importPath + importFileName + ".bin");
				// file check
				if (file.exists()) {
					importing = false;
				}
				else {
					System.out.println("FILE DOES NOT EXISTS!");
					System.out.println("PLEASE TRY OTHER FILE NAME!");
					System.out.println();
					System.out.println("Do you want to try again?");
					System.out.println("Y for yes : N for no");
					System.out.print("   >>>>: ");
					importErrorResponse = userInput.nextLine().toUpperCase().charAt(0);
					if (importErrorResponse == ('Y')) {
						System.out.print("\t\t : PROCEEDING :");
						Delay.dotLoading("short");
					}
					else if (importErrorResponse == 'N') {
						importing = false;
					}
					else {
						System.out.print(": REDIRECTING TO MAIN MENU :");
						Delay.dotLoading("short");
						importing = false;
					}
				}
			}
			else {
				resetImportInputs();
				resetConditions();
				System.out.println("\n\t    INVALID FILE PATH (!)3");
				System.out.println("Do you want to try again?");
				System.out.println("Y for yes : N for no");
				System.out.print("   >>>>: ");

				importErrorResponse = userInput.nextLine().toUpperCase().charAt(0);
				if (importErrorResponse == ('Y')) {
					resetImportInputs();
					resetConditions();
					System.out.print("\t\t : PROCEEDING :");
					Delay.dotLoading("short");
				}
				else if (importErrorResponse == 'N') {
					System.out.print(": REDIRECTING TO MAIN MENU :");
					Delay.dotLoading("short");
					importing = false;
				}
				else {
					System.out.print(": REDIRECTING TO MAIN MENU :");
					Delay.dotLoading("short");
					break;
				}
			}
		}
		try {
			// solving
			if(Objects.equals(fileType, "bin")) {
				assert file != null;
				if (file.exists()) {
					Process.studentsList = FileUtil.readFileBinary(importPath, importFileName);
					setImportingText();
					resetImportInputs();
					resetConditions();
				}
				else {
					System.out.println(" : FILE IS NOT A VALID FILE (!) : ");
				}
			}
			else {
				System.out.println("ERROR");
			}
		}
		catch (NullPointerException ignored) {
			System.out.println("     : INVALID CHOICE (!) :    ");
		}
		resetImportInputs();
	}

	/**
	 * Method that shows the list of students by iterating through the {@code ArrayList} studentsList
	 * <p> If {@code studentsList.size() == 0}, outputs list is empty
	 * @throws InterruptedException if the thread is interrupted
	 */
	protected static void showList() throws InterruptedException {

		if (isEmptyList())
			System.out.println("              : THE LIST IS EMPTY :            ");
		else {
			for (byte id = 0; id < studentsList.size(); id++) {
				Decorations.line();
				System.out.println("Student No: " + (id + 1));
				System.out.println(studentsList.get(id).toString());
				if (studentsList.size() > 1)
					Delay.pause();
			}
		}
	}

	/**
	 * Method that removes 1 student from the {@code ArrayList} studentsList
	 * <p> If {@code studentsList.size() == 0}, outputs list is empty
	 * @throws InterruptedException if the thread is interrupted
	 */
	protected static void removeInTheList() throws InterruptedException {

		String id = "";
		removeLrn = true;
		/* Gets the right input from the user
		 * converting the string to byte
		 */
		while (removeLrn) {
			if (isEmptyList()) {
				System.out.println("              : THE LIST IS EMPTY :            ");
				removeLrn = false;
			}
			else {
				if (!isIdExisted(id) && !invalidIdDeletion) {
					showList();
				}
				System.out.println(":-------------------------------:");
				System.out.println(" :ENTER STUDENT ID FOR DELETION: ");
				System.out.println(":-------------------------------:");
				System.out.print("   >>>>: ");

				id = userInput.nextLine().trim();

				if (id.matches("[0-9]+") && ( id.length() == 10 || id.length() == 11 || id.length() == 12) ) {
					removeLrn = false;
				}
				else {
					System.out.println("    : THAT LRN DOES NOT EXIST (!) :   ");
					invalidIdDeletion = true;
				}
				//solve
				if (isIdExisted(id)) {
					final String finalId = id;
					studentsList.removeIf(obj -> obj.getId().equals(finalId)); // ito
					System.out.print("          : REMOVING FROM THE LIST :");
					Delay.dotLoading("long");
					System.out.println("\n    SUCCESSFULLY REMOVED FROM THE LIST (!)");
					invalidIdDeletion = false;
				}
				if (invalidIdDeletion) {
					tryAgain();
				}
			}
		}
	}

	/**
	 * Method that sort the list of Students
	 * @throws InterruptedException if the thread is interrupted
	 */
	protected static void sortStudentList() throws InterruptedException {

		String choice2 = "";
		String temporaryString;
		String emptySize = "       : THE LIST IS EMPTY :     ";
		String lessStudent = ":THERE IS ONLY 1 STUDENT IN THE LIST:";
		while (sorting) {
			while (empty) {
				if (isEmptyList() || studentsList.size() == 1) {
					Decorations.line();
					if (studentsList.size() == 1) {
						emptySortingLoopChoice = true;
						System.out.println(lessStudent);
						System.out.println(":------------------------------------:");
						System.out.println(": ARE YOU SURE YOU WANT TO SORT NOW? :");
						System.out.println("            : YES OR NO :             ");
						System.out.println(":------------------------------------:");
						System.out.print("   >>>>: ");
						choice2 = userInput.nextLine().toUpperCase().trim();
					}
					else {
						System.out.println(emptySize);
						Decorations.line();
						sorting = false;
						empty = false;
						nextStep = false;
						System.out.print("    : REDIRECTING TO MAIN MENU :");
						Delay.dotLoading("short");
					}
					while(emptySortingLoopChoice){
						switch (choice2) {
							case SECOND_RESPONSE -> {
								nextStep = false;
								sorting = false;
								emptySortingLoopChoice = false;
								System.out.print(": REDIRECTING TO MAIN MENU :");
								Delay.dotLoading("short");
							}
							case FIRST_RESPONSE -> {
								System.out.print("\t\t : PROCEEDING :");
								Delay.dotLoading("short");
								emptySortingLoopChoice = false;
								empty = false;
							}
							default -> {
								if(!choice2.contains("YES") || !choice2.contains("NO")) {
									System.out.println("\t\t   :Invalid Input (!):");
									System.out.print(": REDIRECTING TO MAIN MENU :");
									Delay.dotLoading("short");
									emptySortingLoopChoice = false;
									empty = false;
									nextStep = false;
									sorting = false;
								}
							}
						}
					}
				}
				empty = false;
			}
			while (nextStep) {
				if (isNotEmptyList() || ( isEmptyList() && choice2.equals(FIRST_RESPONSE) ) ) {
					System.out.println();
					System.out.println("NUMBER :" + Constants.SORT_IN_ID_ASCENDING + " : FOR...  Sort Ascending  by student ID .");
					System.out.println("NUMBER :" + Constants.SORT_IN_ID__DESCENDING + " : FOR...  Sort Descending by student ID.");
					System.out.println("NUMBER :" + Constants.SORT_IN_LAST_NAME_ASCENDING + " : FOR...  Sort Ascending  by student LAST_NAME .");
					System.out.println("NUMBER :" + Constants.SORT_IN_LAST_NAME_DESCENDING + " : FOR...  Sort Descending by student LAST_NAME.");
					System.out.println("NUMBER :" + Constants.SORT_IN_FIRST_NAME_ASCENDING + " : FOR...  Sort Ascending  by student FIRST_NAME .");
					System.out.println("NUMBER :" + Constants.SORT_IN_FIRST_NAME_DESCENDING + " : FOR...  Sort Descending by student FIRST_NAME.");
					System.out.println("NUMBER :" + Constants.SORT_IN_AGE_ASCENDING + " : FOR...  Sort Ascending  by student AGE .");
					System.out.println("NUMBER :" + Constants.SORT_IN_AGE__DESCENDING + " : FOR...  Sort Descending by student AGE.");
					System.out.println("NUMBER :" + Constants.SORT_IN_GENDER_ASCENDING + " : FOR...  Sort Ascending  by student GENDER .");
					System.out.println("NUMBER :" + Constants.SORT_IN_GENDER_DESCENDING + " : FOR...  Sort Descending by student GENDER.");
					System.out.println("NUMBER :" + Constants.SORT_IN_SCHOOL_NAME_ASCENDING + " : FOR...  Sort Ascending  by student SCHOOL_NAME .");
					System.out.println("NUMBER :" + Constants.SORT_IN_SCHOOL_NAME_DESCENDING + ": FOR...  Sort Descending by student SCHOOL_NAME.");
					System.out.println("NUMBER :" + Constants.SORT_IN_COURSE_NAME_ASCENDING + ": FOR...  Sort Ascending  by student COURSE_NAME .");
					System.out.println("NUMBER :" + Constants.SORT_IN_COURSE_NAME_DESCENDING + ": FOR...  Sort Descending by student COURSE_NAME.");

					if (isNotEmptyList() || ( isEmptyList() && choice2.equals(FIRST_RESPONSE) ) ) {
						System.out.println(":-----------------------------:");
						System.out.println(":        SELECT CHOICE        : ");
						System.out.println(":-----------------------------:");
						System.out.print("   >>>>: ");
						temporaryString = userInput.nextLine().trim();
						if (InputChecker.isByte(temporaryString)) {
							sortingChoice = Byte.parseByte(temporaryString);
						}
						nextStep = false;
						sorting = false;
					}
					else
						System.out.println("\t\t  :  INVALID INPUT (!)  :");
				}
				else
					sorting = false;
				//solving
				switch (sortingChoice) {
					case Constants.SORT_IN_ID_ASCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortIdAscending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_ID__DESCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortIdDescending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_LAST_NAME_ASCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortLastNameAscending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_LAST_NAME_DESCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortLastNameDescending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_FIRST_NAME_ASCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortFirstNameAscending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_FIRST_NAME_DESCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortFirstNameDescending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_AGE_ASCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortAgeAscending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_AGE__DESCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortAgeDescending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_GENDER_ASCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortGenderAscending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_GENDER_DESCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortGenderDescending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_SCHOOL_NAME_ASCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortSchoolNameAscending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_SCHOOL_NAME_DESCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortSchoolNameDescending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_COURSE_NAME_ASCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortCourseNameAscending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					case Constants.SORT_IN_COURSE_NAME_DESCENDING -> {
						System.out.print("\t\t\t :SORTING:");
						Delay.dotLoading("long");
						SortProcessing.sortCourseNameDescending(studentsList);
						System.out.println("\n\t      SUCCESSFULLY SORTED (!)");
					}
					default -> System.out.println("\t      INVALID SORT CHOICE (!)");
				}
			}
		}
	}

	/**
	 * One way process reset, resets some conditions by calling them.
	 * <p> Resets: {@code lrnResponse = ""}
	 * <p> Called in: {@link Process#addList() addList()} method.
	 * <p> Called methods: {@link Process#resetConditions() resetConditions()},
	 * {@link Process#resetImportInputs() resetImportInputs()}
	 */
	protected static void processReset() {
		resetConditions();
		resetImportInputs();
		lrnResponse = "";
	}

	/**
	 * Resets the fields that are used in the main menu choices
	 * <p> Resets:
	 * <p> {@code choiceCheck = true}
	 * <p> {@code importChoiceLoop = true}
	 * <p> {@code exportChoiceLoop = true}
	 * <p> {@code isValidMainChoice = false}
	 * <p> {@code mainChoice = 0}
	 * <p> Called in: {@link MainActivity#run() run()}, and {@link Process#addList() addList()} methods
	 */
	protected static void resetMain() {
		choiceCheck  = true;
		importChoiceLoop = true;
		exportChoiceLoop = true;
		isValidMainChoice = false;
		mainChoice = 0;
	}

	/**
	 * Resets the inputs that are used in {@code run()}, {@code importList()}, and {@code processReset()} methods.
	 * <p> Resets:
	 * <p> {@code importPath = ""}
	 * <p> {@code importFileName = ""}
	 * <p> {@code importFileTypeChoice = 0}
	 * <p> {@code importErrorResponse = ' '}
	 * <p> Called in: {@link MainActivity#run() run()}, {@link Process#importList(String) importList()},
	 * and {@link Process#processReset() processReset()} methods.
	 */
	protected static void resetImportInputs() {
		importPath = "";
		importFileName = "";
		importFileTypeChoice = 0;
		importErrorResponse = ' ';
	}

	/**
	 * Resets the inputs that are used in {@code run()}, and {@code exportList()}, methods.
	 * <p> Resets:
	 * <p> {@code exportPath = ""}
	 * <p> {@code exportFileName = ""},
	 * <p> {@code exportFileTypeChoice = 0}
	 * <p> {@code exportErrorResponse = ' '}
	 * <p> Called in: {@link MainActivity#run() run()}, {@link Process#exportList(String) exportList()},
	 * and {@link Process#processReset() processReset()} methods.
	 */
	protected static void resetExportInputs() {
		exportPath = "";
		exportFileName = "";
		exportFileTypeChoice = 0;
		exportErrorResponse = ' ';
	}

	/**
	 * Resets the looping conditions used in adding a student
	 * <p> Resets :
	 * <p> {@code addFirstName = true}
	 * <p> {@code addLastName = true}
	 * <p> {@code addGender = true}
	 * <p> {@code addSchool = true}
	 * <p> {@code addCourse = true}
	 * <p> {@code addStudentId = true}
	 * <p> {@code addAge = true}
	 * <p> Called in: {@link MainActivity#run() run()}, {@link Process#createStudent() createStudent()},
	 * {@link Process#exportList(String) exportList()}, {@link Process#importList(String) importList()},
	 * and {@link Process#processReset() processReset()} methods.
	 */
	protected static void resetCreateStudentConditions() {
		addFirstName = true;
		addLastName = true;
		addGender = true;
		addSchool = true;
		addCourse = true;
		addStudentId = true;
		addAge = true;
	}

	/**
	 * Resets the looping conditions used some methods in the {@code Process} class
	 * <p> Resets:
	 * <p> {@code sorting = true}
	 * <p> {@code sortingChoice = 0}
	 * <p> {@code emptySortingLoopChoice = false}
	 * <p> {@code nextStep = true}
	 * <p> {@code exporting = true},
	 * <p> {@code importing = true}
	 * <p> {@code removeLrn = true}
	 * <p> {@code empty = true}
	 * <p> {@code invalidIdDeletion = false}.
	 * <p> Called in: {@link Process#addList() addList()} method.
	 */
	protected static void resetConditions() {
		sorting = true;
		sortingChoice = 0;
		emptySortingLoopChoice = false;
		nextStep = true;
		exporting = true;
		importing = true;
		removeLrn = true;
		empty = true;
		invalidIdDeletion = false;
	}

	/**
	 * Negates the looping conditions in {@code createStudent} method.
	 * Used in cases where the user did not enter inputs properly.
	 * It makes the whole createStudent method conditions to false.
	 * <p> Resets :
	 * <p> {@code addFirstName = false}
	 * <p> {@code addLastName = false}
	 * <p> {@code addGender = false}
	 * <p> {@code addSchool = false}
	 * <p> {@code addCourse = false}
	 * <p> {@code addStudentId = false}
	 * <p> {@code addAge = false}
	 * <p> Called in: {@link Process#tryAgain() tryAgain()} method
	 */
	protected static void negateCreateStudentFunction() {
		addFirstName = false;
		addLastName = false;
		addGender = false;
		addSchool = false;
		addCourse = false;
		addStudentId = false;
		addAge = false;
	}

	/**
	 * Outputs when the user is done executing certain functions.
	 * <p> Pauses the console.
	 * <p> Called in: {@link MainActivity#run() run()} method
	 */
	protected static void clearConsole() {
		System.out.println(":---------------------------------------------:");
		System.out.println("           : PRESS ENTER TO CONTINUE :         ");
		System.out.println(":---------------------------------------------:");
	}

	/**
	 * Checks if {@code studentList} ArrayList is empty
	 * <p> Called in: {@link Process#showList() showList()}, {@link Process#removeInTheList() removeInTheList()},
	 * and {@link Process#sortStudentList() sortStudentList()} methods.
	 * @return {@code true} if the {@code studentList} ArrayList is empty or no {@code Objects}
	 */
	protected static boolean isEmptyList() {
		return (studentsList.size() == 0);
	}

	/**
	 * Checks if {@code studentList} ArrayList is not empty
	 * <p> Called in: {@link Process#sortStudentList() sortStudentList()} method.
	 * @return {@code true} if the {@code studentList} ArrayList is not empty or has {@code Objects}
	 */
	protected static boolean isNotEmptyList() {
		return (studentsList.size() != 0);
	}

	/**
	 * Clears the list.
	 * <p> Called in: {@link MainActivity#run() run()} method, from {@link Process} class
	 */
	protected static void clearList() {
		studentsList.clear();
	}

	/**
	 * Method that shows the total number of students, or simply returns the current size of the {@code studentsList} ArrayList
	 * <p> Called in: {@link MainActivity#run() run()} method, from {@link Process} class
	 */
	protected static void numberOfStudent() {
		System.out.println("  Number Of Students: "+ studentsList.size());
	}

	/**
	 * Checks if an LRN is existed, iterating through the {@code studentsList} ArrayList using an enhanced for loop.
	 * Getting every ID and comparing it with the id that is passed in.
	 * @param id student ID
	 * @return {@code true} if the student ID already existed.
	 */
	protected static boolean isIdExisted(final String id) {
		// looping
		for (Student student : studentsList) {
			if (student.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Method that initializes the {@code mainChoices}, {@code userInput} fields declared in {@link Process} class.
	 * <p> The {@code mainChoices} field is used in the {@link MainActivity#run() run()} method of the {@link MainActivity} class.
	 * <p> The {@code userInput} field is used in the {@link Process#createStudent() createStudent()},
	 * {@link Process#tryAgain() tryAgain()}, {@link Process#exportList(String) exportList()}, {@link Process#importList(String) importList()},
	 * {@link Process#removeInTheList() removeInTheList()}, and {@link Process#sortStudentList() sortStudentList()}, methods of the {@link MainActivity} class.
	 */
	protected static void initialize() {
		mainChoice = 0;
		userInput = new Scanner(System.in);
	}

	/**
	 * Method that creates a {@code Student} object and adding that object in the {@code studentsList} ArrayList.
	 * It also removes any null objects in the ArrayList studentsList using a lambda.
	 * <p> Called in: {@link MainActivity#run() run()} of {@link MainActivity} class.
	 * <p> {@link Process#createStudent() createStudent()}, {@link Process#processReset() processReset()}, {@link Process#resetMain() resetMain()},
	 * and {@link Process#resetConditions() resetConditions()}, methods of the {@link Process} class.
	 * @throws InterruptedException if the thread is interrupted
	 */
	protected static void addList() throws InterruptedException {
		Student newStudent = createStudent();
		studentsList.add(newStudent);
		try {
			for (int i = 0; i < studentsList.size(); i++) {
				studentsList.removeIf(student -> student.getId() == null);
			}
		} 
		catch (NullPointerException ignored) {
		}
		if(lrnResponse.equals("YES")) {
			System.out.println("\n         STUDENT ADDED SUCCESSFULLY (!)");
			resetMain();
			processReset();
			resetCreateStudentConditions();
		}
		else if (lrnResponse.equals("NO")) {
			resetMain();
			processReset();
			resetCreateStudentConditions();
		}
		else {
			if (lrnResponse.isBlank() && (invalidId && lrnResponse.matches("[!@#$%^&*()a-zA-Z]+")) ) {
				System.out.print(' ');
			}
			else if(lrnResponse.isBlank() && invalidId) {
				System.out.print(' ');
			}
			else if(invalidId) {
				System.out.print(' ');
			}
			else {
				System.out.println("\n         STUDENT ADDED SUCCESSFULLY (!)");
			}
			resetMain();
			processReset();
			resetCreateStudentConditions();
		}	
	}

	/**
	 * Creates a loading output when importing. This only shows the import process is a success.
	 * It also called the {@link Delay#dotLoading(String) dotLoading()} method of the {@link Delay} class.
	 * <p> Called in: {@link Process#importList(String) importList()}, method of the {@link Process} class.
	 * @throws InterruptedException if the thread is interrupted
	 */
	protected static void setImportingText() throws InterruptedException {
		System.out.print("                : IMPORTING :");
		Delay.dotLoading("long");
		System.out.println("            SUCCESSFULLY IMPORTED (!)");
	}
}
	