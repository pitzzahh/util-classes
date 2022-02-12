package lib.games.headAndTails;

import java.util.InputMismatchException;
import lib.utilities.misc.InputChecker;
import lib.utilities.misc.Decorations;
import java.util.Scanner;

public final class HeadAndTails {
	private HeadAndTails() {}
		// Head Tails, lmao Warang maisip hahhahhahha
	public static void run() {
		try {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Number: ");
			String input = keyboard.nextLine().trim();
			if (InputChecker.isInteger(input)) {
				int number = Integer.parseInt(input);
				if (number > 0) {
					if (number % 5 == 0) {
						if (number % 3 == 0) {
							System.out.println("HeadTail");
							// HeadTails if number is divisible by 5 and 3.
						}
						else {
							System.out.println("Head");
						}
						// Head if number is divisible by 5.
					}
					else if (number % 3 == 0) {
						System.out.println("Tail");
						// Tail if number is divisible by 3.
					}
					else {
						System.out.println(number);
						// if not, inserted number will be printed out.
					}
				}
			}
			else {
				System.out.println(Decorations.TEXT_RED + "NOT A NUMBER (!)" + Decorations.TEXT_RESET);
			}
			keyboard.close();
		}
		catch (InputMismatchException e) {
			System.out.println(Decorations.TEXT_RED + "NUMBERS ONLY" + Decorations.TEXT_RESET);
		}
	}
}

		





