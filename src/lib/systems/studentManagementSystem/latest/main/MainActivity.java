package lib.systems.studentManagementSystem.latest.main;

import lib.systems.studentManagementSystem.latest.processes.framework.Process;
import lib.systems.studentManagementSystem.latest.constants.Constants;
import static lib.utilities.delay.Loading.dotLoading;
import static lib.utilities.decor.Decorations.line;
import lib.utilities.inputChecker.InputChecker;
import java.util.Scanner;

public final class MainActivity extends Process{

	/**
	 * stores all the user inputs in this Class
	 */
	private static String temporaryString = "";

	/**
	 * Runs the program
	 */
    public void run() throws InterruptedException {
		Process.initialize();
		Scanner mainScanner = new Scanner(System.in);
        while (Process.isNotExit) {
			menu();
            // Gets users choice
            while (Process.choiceCheck) {
    			System.out.println(":-----------------------------:");
    			System.out.println(":      ENTER YOUR CHOICE      : ");
    			System.out.println(":-----------------------------:");
    			System.out.print("   >>>>: ");
            	temporaryString = mainScanner.nextLine().trim(); // 1
            	// checks and converts string input to byte
            	if (InputChecker.isByte(temporaryString)) {
					Process.mainChoice = Byte.parseByte(temporaryString); // 1
					Process.isValidMainChoice = true;
					Process.resetImportInputs();
            	}
                else {
					System.out.println("              : INVALID INPUT (!) :            ");
					temporaryString = " ";
				}
				Process.choiceCheck = false;
            }
            // solving
			if (Process.isValidMainChoice) {
				switch (Process.mainChoice) {
					case Constants.ADD_STUDENT_FUNCTION -> Process.addList();
					case Constants.SHOW_STUDENT_FUNCTION -> Process.showList();
					case Constants.SORT_STUDENT_FUNCTION -> Process.sortStudentList();
					case Constants.REMOVE_STUDENT_FUNCTION -> Process.removeInTheList();

					// IMPORTING
					case Constants.IMPORT_STUDENT_FUNCTION -> {

						// getting the file information of file type if Binary file.
						importMenu();

						// input
						while (Process.importChoiceLoop) {

							System.out.println(":-----------------------------:");
							System.out.println(":      ENTER YOUR CHOICE      : ");
							System.out.println(":-----------------------------:");
							System.out.print("   >>>>: ");

							temporaryString = mainScanner.nextLine().trim();

							if (InputChecker.isByte(temporaryString)) {
								Process.importFileTypeChoice = Byte.parseByte(temporaryString);
								if (Process.importFileTypeChoice == 1) {
									Process.importList("bin");
									Process.importChoiceLoop = false;
								}
								else {
									try {
										System.out.println("\n\t  INVALID INPUT (!) ");
										System.out.println("Do you want to try again?");
										System.out.println("Y for yes : N for no");
										System.out.print("   >>>>: ");
										temporaryString = mainScanner.nextLine().toUpperCase().trim();
										Process.importErrorResponse = temporaryString.charAt(0);
										if (Process.importErrorResponse == ('Y')) {
											Process.resetConditions();
											Process.resetImportInputs();
											importMenu();
										}
										else if (Process.importErrorResponse == 'N') {
											Process.importChoiceLoop = false;
										}
										else {
											System.out.println("     : INVALID CHOICE (!) :      ");
											System.out.print(": REDIRECTING TO MAIN MENU :");
											dotLoading();
											Process.importChoiceLoop = false;
										}
									}
									catch (StringIndexOutOfBoundsException ignored) {
										System.out.println("     : INVALID CHOICE (!) :      ");
										importMenu();
									}
								}
							}
							else {
								try {
									System.out.println("\n\t  INVALID INPUT (!)");
									System.out.println("Do you want to try again?");
									System.out.println("Y for yes : N for no");
									System.out.print("   >>>>: ");
									temporaryString = mainScanner.nextLine().toUpperCase().trim();
									Process.importErrorResponse = temporaryString.charAt(0);
									if (Process.importErrorResponse == ('Y')) {
										Process.resetConditions();
										Process.resetImportInputs();
										importMenu();
									}
									else if (Process.importErrorResponse == 'N') {
										Process.importChoiceLoop = false;
									}
									else {
										System.out.println("     : INVALID CHOICE (!) :      ");
										System.out.print(": REDIRECTING TO MAIN MENU :");
										dotLoading();
										Process.importChoiceLoop = false;
									}
								}
								catch (StringIndexOutOfBoundsException ignored) {
									System.out.println("     : INVALID CHOICE (!) :      ");
									importMenu();
								}
							}
						}
					}
					// EXPORTING
					case Constants.EXPORT_STUDENT_FUNCTION -> {
						if (Process.studentsList.size() != 0) {

							// getting the file information of file type if Binary of text file.
							exportMenu();

							// input
							while (Process.exportChoiceLoop) {
								System.out.println(":-----------------------------:");
								System.out.println(":      ENTER YOUR CHOICE      : ");
								System.out.println(":-----------------------------:");
								System.out.print("   >>>>: ");

								temporaryString = mainScanner.nextLine().trim();

								if (InputChecker.isByte(temporaryString)) {
									Process.exportFileTypeChoice = Byte.parseByte(temporaryString);
									if (Process.exportFileTypeChoice == 1) {
										Process.exportList("text");
										Process.exportList("bin");
										Process.exportChoiceLoop = false;
									}
									else {
										try {
											System.out.println("\n\t  INVALID INPUT (!)");
											System.out.println("Do you want to try again?");
											System.out.println("Y for yes : N for no");
											System.out.print("   >>>>: ");
											Process.exportErrorResponse = mainScanner.nextLine().toUpperCase().trim().charAt(0);
											if (Process.exportErrorResponse == ('Y')) {
												Process.resetConditions();
												Process.resetExportInputs();
												exportMenu();
											}
											else if (Process.exportErrorResponse == 'N') {
												Process.exportChoiceLoop = false;
											}
											else {
												System.out.println("     : INVALID CHOICE (!) :      ");
												System.out.print(": REDIRECTING TO MAIN MENU :");
												dotLoading();
												Process.exportChoiceLoop = false;
											}
										}
										catch (StringIndexOutOfBoundsException ignored) {
											System.out.println("     : INVALID CHOICE (!) :      ");
											exportMenu();
										}
									}
								}
								else {
									try {
										System.out.println("\n\t  INVALID INPUT (!)");
										System.out.println("Do you want to try again?");
										System.out.println("Y for yes : N for no");
										System.out.print("   >>>>: ");
										temporaryString = mainScanner.nextLine().toUpperCase().trim();
										Process.importErrorResponse = temporaryString.charAt(0);
										if (Process.exportErrorResponse == ('Y')) {
											Process.resetConditions();
											Process.resetExportInputs();
											exportMenu();
										}
										else if (Process.exportErrorResponse == 'N') {
											Process.exportChoiceLoop = false;
										}
										else {
											System.out.println("     : INVALID CHOICE (!) :      ");
											System.out.print(": REDIRECTING TO MAIN MENU :");
											dotLoading();
											Process.exportChoiceLoop = false;
										}
									}
									catch (StringIndexOutOfBoundsException ignored) {
										System.out.println("     : INVALID CHOICE (!) :      ");
										exportMenu();
									}
								}
							}
						}
						else {
							line();
							System.out.println("            : THE LIST IS EMPTY (!) :       ");
							System.out.println("     : NO PRESENT DATA TO BE EXPORTED (!) :    ");
							line();
						}
					}
					case Constants.EXIT_FUNCTION -> Process.isNotExit = false;
					default -> System.out.println("              : INVALID CHOICE (!) :            ");
				}
			}
            if (!Process.isNotExit) {
            	Process.clearList();
            	break;
            }
            // clears and pause the console
            Process.clearConsole();
			while (temporaryString != null) {
				if (temporaryString.isEmpty()) {
					break;
				}
				if (mainScanner.hasNextLine()) {
					temporaryString = mainScanner.nextLine();
				}
				else {
					temporaryString = null;
				}
			}
			// resets the conditions in Process class fields and fields for MainActivity class
			Process.resetConditions();
			Process.resetImportInputs();
			Process.resetExportInputs();
			Process.resetMain();
        }
		System.out.print("            : EXITING THE PROGRAM :");
		dotLoading();
		line();
		System.out.println("        THANK YOU FOR USING MY PROGRAM");
		line();
		mainScanner.close();
	}
	/**
	 * main menu selections
	 */
	static void menu() {
		System.out.println(":-----------------------------------------------------------------:");
		Process.numberOfStudent();
		System.out.println(":-----------------------------------------------------------------:");
		System.out.println("                     Student Management System                     ");
		System.out.println(":-----------------------------------------------------------------:");
		System.out.println("NUMBER :" + Constants.ADD_STUDENT_FUNCTION + ": Add student");
		System.out.println("NUMBER :" + Constants.SHOW_STUDENT_FUNCTION + ": Show student list ");
		System.out.println("NUMBER :" + Constants.SORT_STUDENT_FUNCTION + ": Sort student list ");
		System.out.println("NUMBER :" + Constants.REMOVE_STUDENT_FUNCTION + ": Remove student  ");
		System.out.println("NUMBER :" + Constants.IMPORT_STUDENT_FUNCTION + ": Import student list");
		System.out.println("NUMBER :" + Constants.EXPORT_STUDENT_FUNCTION + ": Export student list");
		System.out.println("NUMBER :" + Constants.EXIT_FUNCTION + ": Exit");
		System.out.println(":-----------------------------------------------------------------:");
	}
	/**
	 * Import menu selections
	 */
	static void importMenu() {
		System.out.println(":------------------------------:");
		System.out.println(": Choose a File Type to Import :");
		System.out.println(": NUMBER :1: Binary File       :");
		System.out.println(":------------------------------:");
	}
	/**
	 * Export menu selections
	 */
	static void exportMenu() {
		System.out.println(":------------------------------:");
		System.out.println(": Choose a File Type to Export :");
		System.out.println(": NUMBER :1: Text File (csv)   :");
		System.out.println(":------------------------------:");
	}
}

